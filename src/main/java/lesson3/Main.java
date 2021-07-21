package lesson3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Apple> apples = new ArrayList<>();
        ArrayList<Orange> oranges = new ArrayList<>();
        ArrayList<Fruit> fruits = new ArrayList<>();

        BoxOfFruit<Apple> box1 = new BoxOfFruit<>(apples);
        BoxOfFruit<Orange> box2 = new BoxOfFruit<>(oranges);

        box1.array.add(new Apple(1.0));
        box1.array.add(new Apple(1.0));
        box1.array.add(new Apple(1.0));

        box2.array.add(new Orange(1.5));

        System.out.println("Вес коробки box1 = " + box1.getWeight(box1));
        System.out.println("Вес коробки box2 = " + box2.getWeight(box2));

        System.out.println(box1.compareWeight(box2));

    }

}
