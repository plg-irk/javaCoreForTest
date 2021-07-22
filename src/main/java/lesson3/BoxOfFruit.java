package lesson3;

import java.util.ArrayList;

public class BoxOfFruit<T> {

    public ArrayList<T> array;

    public BoxOfFruit() {
        this.array = new ArrayList<>();
    }

    public void addFruitToBox(T fruit) {
        if (array.isEmpty() ||
                array.get(0).getClass().getSimpleName().
                        equals(fruit.getClass().getSimpleName()))
            array.add(fruit);
        else System.out.println("Нельзя добавить фрукт. Пересортировка");
    }

    public boolean compare(BoxOfFruit<?> box) {
        boolean result = false;
        if (array.size() == box.array.size()) {
            if (array.get(0).getClass().getSimpleName().
                    equals(box.array.get(0).getClass().getSimpleName()))
                result = true;
        }
        return result;
    }

    public double getWeight() {
        double result = 0;
        int num = 0;
        for (int i = 0; i < array.size(); i++) {
            num += 1;
        }
        if (array.get(0).
                getClass().getSimpleName().equals("Apple")) {
            result = num * Apple.weight;
        } else {
            if (array.get(0).
                    getClass().getSimpleName().equals("Orange")) {
                result = num * Orange.weight;
            } else System.out.println("Подсчитать вес коробки невозможно");
        }
        return result;
    }

    public void overNextBox(BoxOfFruit<T> box) {
        if (box.array.isEmpty() ||
                box.array.get(0).getClass().getSimpleName().
                        equals(array.get(0).getClass().getSimpleName()))
            for (int i = 0; i < array.size(); i++) {
                box.addFruitToBox(array.get(i));
            }
        else System.out.println("Пересыпать не возможно");
        array.clear();
    }

}
