package lesson3;

public class Main {

    public static void main(String[] args) {

        Apple apple = new Apple();
        Orange orange = new Orange();

        BoxOfFruit<Fruit> box1 = new BoxOfFruit<>();
        BoxOfFruit<Fruit> box2 = new BoxOfFruit<>();
        BoxOfFruit<Fruit> box3 = new BoxOfFruit<>();
        BoxOfFruit<Fruit> box4 = new BoxOfFruit<>();

        box1.addFruitToBox(apple);
        box1.addFruitToBox(apple);
        box1.addFruitToBox(apple);
        box1.addFruitToBox(apple);
        box1.addFruitToBox(apple);
        box1.addFruitToBox(apple);

        box2.addFruitToBox(orange);
        box2.addFruitToBox(orange);

        box3.addFruitToBox(orange);
        box3.addFruitToBox(orange);
        box3.addFruitToBox(apple);

        System.out.println("Результат сравнения коробок 1,1: " +
                box1.compare(box1));
        System.out.println("Результат сравнения коробок 1,2: " +
                box1.compare(box2));
        System.out.println("Результат сравнения коробок 2,3: " +
                box2.compare(box3));

        System.out.println("Вес коробки box1 = " + box1.getWeight());
        System.out.println("Вес коробки box2 = " + box2.getWeight());
        System.out.println("Вес коробки box3 = " + box3.getWeight());

        box1.overNextBox(box2);

        box1.overNextBox(box4);
        System.out.println("В коробке 1 фруктов: " + box1.array.size());
        System.out.println("В коробке 4 фруктов: " + box4.array.size());

        box2.overNextBox(box3);
        System.out.println("В коробке 2 фруктов: " + box2.array.size());
        System.out.println("В коробке 3 фруктов: " + box3.array.size());

    }

}

