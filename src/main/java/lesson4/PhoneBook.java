package lesson4;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    HashMap<Integer, String> book;

    public PhoneBook() {
        this.book = new HashMap<>();
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "book=" + book +
                '}';
    }

    public void add(String name, Integer phone) {
        book.put(phone, name);
    }

    public void get(String name) {
        ArrayList<Integer> arrayPhone = new ArrayList<>();
        for (Integer i:book.keySet()) {
            if (book.get(i).equals(name)) arrayPhone.add(i);
        }
        System.out.println("По фамилии " + name +
                " есть такие номера " + arrayPhone);
    }
}
