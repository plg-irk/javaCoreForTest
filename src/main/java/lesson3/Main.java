package lesson3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Apple> fruits1 = new ArrayList<>();
        ArrayList<Orange> fruits2 = new ArrayList<>();
        ArrayList<Fruit> fruits3= new ArrayList<>();

        BoxOfFruit<Apple> box1 = new BoxOfFruit<>(fruits1);
        BoxOfFruit<Orange> box2 = new BoxOfFruit<>(fruits2);
        BoxOfFruit<Fruit> box3 = new BoxOfFruit<>(fruits3);

        box1.array.add(new Apple(1.0));
        box1.array.add(new Apple(1.0));
        box1.array.add(new Apple(1.0));

        box2.array.add(new Orange(1.5));
        box2.array.add(new Orange(1.5));

        box3.array.add(new Orange(1.5));
        box3.array.add(new Orange(1.5));
        box3.array.add(new Apple(1.5));

        System.out.println("Результат сравнения коробок 1,1: " +
                box1.compare(box1));
        System.out.println("Результат сравнения коробок 1,2: " +
                box1.compare(box2));
        System.out.println("Результат сравнения коробок 2,3: " +
                box2.compare(box3));

        System.out.println("Вес коробки box1 = " + getW(box1));
        System.out.println("Вес коробки box2 = " + getW(box2));
        System.out.println("Вес коробки box2 = " + getW(box3));
    }

    public static double getW(BoxOfFruit<?> box) {
        double result = 0;
        int num = 0;
        for (int i = 0; i < box.array.size(); i++) {
            num += 1;
        }
        if (box.array.get(0).
                getClass().getSimpleName().equals("Apple")) {
            result = num * Apple.weight;
        } else {
            if (box.array.get(0).
                    getClass().getSimpleName().equals("Orange")) {
                result = num * Orange.weight;
            } else System.out.println("Подсчитать вес коробки невозможно");
        }
        return result;
    }
}

