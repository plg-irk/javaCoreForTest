package lesson7.entity;

public class Weather {
//    insert into weatherToCity (city, localDay, temperature, dayIcon, nightIcon, id)
        private String city;
        private String localDay;
        private String temperatureMax;
        private String temperatureMin;
        private String dayIcon;
        private String nightIcon;
        private Integer id;

    public Weather(String city, String localDay, String temperatureMax,
                   String temperatureMin, String dayIcon, String nightIcon, Integer id) {
        this.city = city;
        this.localDay = localDay;
        this.temperatureMax = temperatureMax;
        this.temperatureMin = temperatureMin;
        this.dayIcon = dayIcon;
        this.nightIcon = nightIcon;
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDay() {
        return localDay;
    }

    public void setLocalDay(String localDay) {
        this.localDay = localDay;
    }

    public String getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(String temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public String getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(String temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public String getDayIcon() {
        return dayIcon;
    }

    public void setDayIcon(String dayIcon) {
        this.dayIcon = dayIcon;
    }

    public String getNightIcon() {
        return nightIcon;
    }

    public void setNightIcon(String nightIcon) {
        this.nightIcon = nightIcon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
