package lesson2;

public class CreatedArray {
    String[][] intArrays;
    int maxI;
    int maxJ;

    public CreatedArray(int maxI, int maxJ) {
        this.maxI = maxI;
        this.maxJ = maxJ;
        this.intArrays = new String[maxI][maxJ];
    }

    public void setIntArrays() {
        for (int i = 0; i < maxI; i++) {
            for (int j = 0; j < maxJ; j++) {
                intArrays[i][j] = String.valueOf(((int)
                        (Math.random() * (10 - 1)) + 1));
            }
        }
    }

    public void changeElemArrays(int i, int j, String a) {
        if (i <= intArrays.length && j <= intArrays[i].length)
            intArrays[i][j] = a;
        else System.out.println("Вы вышли за границу массива, элемент не заменен");
    }

    public void printArrays() {
        for (String[] intArray : intArrays) {
            for (String i : intArray) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void sumOfElementsArrays() throws MyArraySizeException {
        int result = 0;
        if (intArrays.length != 4 || intArrays[0].length != 4) {
            throw new MyArraySizeException("Размер массива не равен 4х4");
        }
        for (int i = 0; i < maxI; i++) {
            for (int j = 0; j < maxJ; j++) {
                try {
                    int num = Integer.parseInt(intArrays[i][j]);
                    result += num;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка преобразования" +
                            " в строке " + (i + 1) + " столбца " + (j + 1));
                }
            }
        }
        System.out.println("Сумма всех элементов массива: " + result);
    }
}

