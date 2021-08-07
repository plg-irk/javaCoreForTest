package lesson7;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название города: ");
            String city = scanner.nextLine();

            System.out.println("Введите 1 для получения погоды на сегодня;" +
                    "Введите 5 для прогноза на 5 дней;" +
                    " Для выхода введите 0:");

            String command = scanner.nextLine();

            if (command.equals("1") || command.equals("5")) {

                try {
                    controller.getWeather(command, city);
                    DataBaseRepository db = new DataBaseRepository();
                    try {
                        if (command.equals("1"))
                        db.getWeatherFromBase(1);
                        else for (int i = 1; i < 6; i++) {
                            db.getWeatherFromBase(i);
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    System.out.println("Для этого города " + city + " нет прогноза погоды");
                }
            } else if (command.equals("0")) break;
            else
                System.out.println("Вы не правильно выбрали период для прогноза погоды");
        }
    }
}