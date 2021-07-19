package lesson2;

public class Main {
    public static void main(String[] args) throws MyArraySizeException {

        CreatedArray arrays44 = new CreatedArray(4, 4);
        CreatedArray arrays45 = new CreatedArray(4, 5);
        CreatedArray arrays54 = new CreatedArray(5, 4);
        CreatedArray arrays44Change = new CreatedArray(4, 4);

        arrays44.setIntArrays();
        arrays44.printArrays();
        arrays44.sumOfElementsArrays();

        arrays44.setIntArrays();
        arrays44.changeElemArrays(1, 2, "a");
        arrays44.printArrays();
        arrays44.sumOfElementsArrays();

        arrays45.setIntArrays();
        arrays45.printArrays();
        arrays45.sumOfElementsArrays();

        arrays54.setIntArrays();
        arrays54.printArrays();
        arrays54.sumOfElementsArrays();

    }
}
//1. Написать метод, на вход которому подается двумерный строковый массив
//      размером 4х4. При подаче массива другого размера необходимо бросить
//      исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать
//      в int и просуммировать. Если в каком-то элементе преобразование
//      не удалось (например, если в ячейке лежит символ
//      или текст вместо числа), надо бросить исключение
//      MyArrayDataException с детализацией, в какой ячейке неверные данные.
//3. В методе main() вызвать полученный метод, обработать возможные
//      исключения MySizeArrayException и MyArrayDataException и вывести
//      результат расчета.