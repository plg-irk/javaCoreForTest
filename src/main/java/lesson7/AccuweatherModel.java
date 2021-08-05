package lesson7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "J1PaNnMEQZ8Np29DwSfpNfHSCHQ5RSGd";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String RU = "ru";
    private static final String LANGUAGE = "language";
    private static final String METRIC = "metric";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE, RU)
                        .addQueryParameter(METRIC, "true")
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                //TODO: сделать человекочитаемый вывод погоды. Выбрать параметры для вывода на свое усмотрение
                System.out.println(selectedCity + " прогноз погоды:");
                printWeather(weatherResponse, 0);
                break;
            case FIVE_DAYS:
                HttpUrl httpUrl5 = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE, RU)
                        .addQueryParameter(METRIC, "true")
                        .build();

                Request request5 = new Request.Builder()
                        .url(httpUrl5)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(request5).execute();
                String weatherResponse5 = fiveDayForecastResponse.body().string();
                //TODO*: реализовать вывод погоды на 5 дней
                System.out.println(selectedCity + " прогноз погоды:");
                for (int i = 0; i < 5; i++)
                    printWeather(weatherResponse5, i);
                break;
        }
    }

    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .addQueryParameter(LANGUAGE, RU)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();
        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        System.out.println("Для этого города нет прогноза погоды");
        return cityKey;
    }

    public void printWeather(String jsonString, int n) throws JsonProcessingException {
        String date = objectMapper.readTree(jsonString)
                .at("/DailyForecasts")
                .get(n)
                .at("/Date")
                .asText();
        String tempMin = objectMapper.readTree(jsonString)
                .at("/DailyForecasts")
                .get(n)
                .at("/Temperature")
                .at("/Minimum")
                .at("/Value")
                .asText();
        String tempMax = objectMapper.readTree(jsonString)
                .at("/DailyForecasts")
                .get(n)
                .at("/Temperature")
                .at("/Maximum")
                .at("/Value")
                .asText();
        String dayIcon = objectMapper.readTree(jsonString)
                .at("/DailyForecasts")
                .get(n)
                .at("/Day")
                .at("/IconPhrase")
                .asText();
        String nightIcon = objectMapper.readTree(jsonString)
                .at("/DailyForecasts")
                .get(n)
                .at("/Night")
                .at("/IconPhrase")
                .asText();
        System.out.println("На: " + date + "\n" +
                "Максимальная температура: " + tempMax + "\n" +
                "Минимальная температура: " + tempMin + "\n" +
                "Днем: " + dayIcon + "\n" +
                "Ночью: " + nightIcon);
        System.out.println();
    }
}
