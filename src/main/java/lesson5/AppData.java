package lesson5;

import java.io.*;

public class AppData {

    private String[] header;
    private int[][] data;

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void read(File fileIn) {

        try (BufferedReader file = new BufferedReader(new
                FileReader(fileIn))) {
            String tempString;
            int num = 0;
            int[][] arrayInt = new int[2][3];
            while ((tempString = file.readLine()) != null) {
                String[] dataParamLine = tempString.split(";");
                if (num == 0) {
                    this.setHeader(dataParamLine);
                } else {
                    for (int i = 0; i < dataParamLine.length; i++) {
                        arrayInt[num - 1][i] = Integer.parseInt(dataParamLine[i]);
                    }
                }
                num += 1;
            }
            this.setData(arrayInt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(File fileOut) {

        try (PrintWriter file = new PrintWriter(new FileWriter(fileOut))) {
            file.println(header[0] + ";" +
                    header[1] + ";" +
                    header[2]);
            for (int[] d : data) {
                file.println(d[0] + ";" + d[1] + ";" + d[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
