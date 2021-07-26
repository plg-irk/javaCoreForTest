package lesson4.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class ArrayString {
    public static void main(String[] args) {
        ArrayList<String> arrayString = new ArrayList<>
                (Arrays.asList("about", "all", "also", "because", "but", "can",
                        "give", "come", "could", "because", "even", "can",
                        "about", "all", "also", "because", "but", "can",
                        "from", "could", "day", "find", "but", "from"
                ));
        System.out.println(arrayString);

        TreeSet<String> setString = new TreeSet<>(arrayString);
        System.out.println(setString);

        HashMap<String, Integer> mapString = new HashMap<>();

        for (String s : setString) {
            int num = 0;
            for (String s1 : arrayString) {
                if (s.equals(s1))
                    num += 1;
            }
            mapString.put(s, num);
        }

        for (String m : mapString.keySet())
            System.out.println("Слово " + m + " встречается: "
                    + mapString.get(m));

    }
}
