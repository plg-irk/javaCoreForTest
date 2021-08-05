package lesson7;

import java.io.IOException;
import java.sql.Connection;
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

            //TODO* Сделать метод валидации пользовательского ввода
            if (command.equals("1") || command.equals("5")) {
                if (command.equals("0")) break;
                try {
                    controller.getWeather(command, city);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    System.out.println("Для этого города нет прогноза погоды");
                }
            } else System.out.println("Вы не правильно выбрали период для прогноза погоды");
        }
    }
}