package lesson8;

import java.sql.*;

public class SqlExamples {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(
                    "jdbc:sqlite:geekbrains.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from weather");
            printDataBase(resultSet);

            String updateWeather = "update weather set city= ?, localDay= ?, temperatureMax=?," +
                    "    temperatureMin = ?, dayIcon = ?, nightIcon = ? where id = ?";

            PreparedStatement saveWeather = connection.prepareStatement(updateWeather);
            saveWeather.setString(1, "CityEx");
            saveWeather.setString(2, "01.01.2020");
            saveWeather.setFloat(3, (float) 22.2);
            saveWeather.setFloat(4, (float) -2.2);
            saveWeather.setString(5, "dayEx");
            saveWeather.setString(6, "nightEx");
            saveWeather.setInt(7,2);
            saveWeather.executeUpdate();

            ResultSet resultSet1 = statement.executeQuery("select * from weather");
            System.out.println("Печать изменений");
            printDataBase(resultSet1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static void printDataBase(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.print(rs.getString("city"));
            System.out.print(" ");
            System.out.print(rs.getString("localDay"));
            System.out.print(" ");
            System.out.println(rs.getFloat("temperatureMax"));
        }
    }
}
