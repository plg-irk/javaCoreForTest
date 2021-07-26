package lesson4;

public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", 12345);
        phoneBook.add("Иванов", 23456);
        phoneBook.add("Петров", 34567);
        phoneBook.add("Сидоров", 45678);
        phoneBook.add("Иванова", 56789);
        phoneBook.add("Петрова", 67890);
        phoneBook.add("Сидорова", 78901);

        System.out.println(phoneBook);

        phoneBook.get("Иванов");
        phoneBook.get("Ивановы");

    }

}
