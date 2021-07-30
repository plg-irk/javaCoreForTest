package lesson5;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        AppData appData = new AppData();

        appData.read(new File("src/main/java/lesson5/temp_in.csv"));
        appData.save(new File("src/main/java/lesson5/temp_out.csv"));

        System.out.println(Arrays.deepToString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData()));

    }
}
