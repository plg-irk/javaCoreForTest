package lesson5;

import java.io.*;
import java.util.ArrayList;

public class AppData {

    private String[] header;
    private Integer[][] data;

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public Integer[][] getData() {
        return data;
    }

    public void setData(Integer[][] data) {
        this.data = data;
    }

    public void read(File fileIn) {
        try (BufferedReader file = new BufferedReader(new
                FileReader(fileIn))) {
            String tempString;
            int num = 0;
            ArrayList<Integer[]> arrayList = new ArrayList<>();
            while ((tempString = file.readLine()) != null) {
                String[] dataParamLine = tempString.split(";");
                if (num == 0) {
                    this.setHeader(dataParamLine);
                } else
                    arrayList.add(stringToIntegerArray(dataParamLine));
                num += 1;
            }
            Integer[][] arrayInt = arrayList.toArray(new Integer[][]{{}});
            this.setData(arrayInt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(File fileOut) {
        try (PrintWriter file = new PrintWriter(new FileWriter(fileOut))) {
            file.println(saveStringToFile(header));
            for (Integer[] d : data) {
                file.println(saveStringToFile(d));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Integer[] stringToIntegerArray(String[] array) {
        ArrayList<Integer> arrayTemp = new ArrayList<>();
        for (String arr : array)
            arrayTemp.add(Integer.parseInt(arr));
        return arrayTemp.toArray(new Integer[]{});
    }

    private <T> String saveStringToFile(T[] arrayIn) {
        String result = "";
        for (int i = 0; i < arrayIn.length; i++) {
            result += arrayIn[i];
            if (i != arrayIn.length - 1)
                result += ";";
        }
        return result;
    }
}
