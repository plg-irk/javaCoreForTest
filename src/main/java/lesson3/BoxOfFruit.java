package lesson3;

import java.util.ArrayList;

public class BoxOfFruit<T extends Fruit> implements GetWeigth {

    public ArrayList<T> array;

    public BoxOfFruit(ArrayList<T> array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "BoxOfFruit{" +
                "array=" + array +
                '}';
    }

    @Override
    public double getWeight(BoxOfFruit<? extends Fruit> box) {
        double sum = 0.0;
        for (int i = 0; i < box.array.size(); i++) {
            sum += box.getArray().get(i).weight;
        }
        return sum;
    }

    public ArrayList<T> getArray() {
        return array;
    }

    public void setArray(ArrayList<T> array) {
        this.array = array;
    }

    public boolean compareWeight(BoxOfFruit<?> box) {
        boolean result = false;
        double weight1 = getWeight(this);
        double weight2 = getWeight(box);
        if (weight1 == weight2) {
            result = true;
            System.out.println("Коробки равны по весу");
        } else {
            if (weight1 <= weight2)
                System.out.println("Вторая коробка тяжелее");
            else System.out.println("Вторая коробка легче");
        }
        return result;
    }
}
