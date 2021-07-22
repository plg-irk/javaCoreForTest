package lesson3;

import java.util.ArrayList;

public class BoxOfFruit<T> {

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

    public ArrayList<T> getArray() {
        return array;
    }

    public void setArray(ArrayList<T> array) {
        this.array = array;
    }

    public void addFruitToBox(Fruit fruit) {
        this.array.add((T) fruit);
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
}
