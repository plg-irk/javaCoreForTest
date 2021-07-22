package lesson3.chapter1;

import java.util.Arrays;

public class CrossArray<T> {
    private T[] array;

    public CrossArray(T... array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "CrossArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public void crossArray(int i, int j) {
        if (i < array.length && j < array.length) {
            T element = array[j];
            array[j] = array[i];
            array[i] = element;
        } else System.out.println("Перестановка не возможна." +
                " Выбранные значения выходят за пределы массива");
    }

    public static void main(String[] args) {

        CrossArray<String> str1 = new CrossArray<>("q", "w", "e", "r", "t");

        System.out.println(str1);
        str1.crossArray(1, 2);
        System.out.println(str1);
    }
}
