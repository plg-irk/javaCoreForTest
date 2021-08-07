package lesson7;

import lesson7.entity.Weather;

import java.sql.*;

public class DataBaseRepository {
    private String updateWeather = "update weatherToCity set city= ?, localDay= ?, temperatureMax=?,\n" +
            "    temperatureMin = ?, dayIcon = ?, nightIcon = ? where id = ?";

    private static final String DB_PATH = "jdbc:sqlite:geekbrains.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveWeatherToBase(Weather weather) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_PATH);
        PreparedStatement saveWeather = connection.prepareStatement(updateWeather);
        saveWeather.setString(1, weather.getCity());
        saveWeather.setString(2, weather.getLocalDay());
        saveWeather.setString(3, weather.getTemperatureMax());
        saveWeather.setString(4, weather.getTemperatureMin());
        saveWeather.setString(5, weather.getDayIcon());
        saveWeather.setString(6, weather.getNightIcon());
        saveWeather.setInt(7, weather.getId());
        System.out.println(saveWeather);
        saveWeather.executeUpdate();
        connection.close();
    }

    public void getWeatherFromBase() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_PATH);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from weatherToCity");
        System.out.println(rs.getString("city"));
        connection.close();
    }

}
