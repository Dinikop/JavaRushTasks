package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1, fileName2, fileName3;
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            fileName3 = reader.readLine();
            reader.close();

            FileInputStream file1Reader = new FileInputStream(fileName1);
            FileOutputStream file2Writer = new FileOutputStream(fileName2);
            FileOutputStream file3Writer = new FileOutputStream(fileName3);

            int count;
            if (file1Reader.available() % 2 == 0) count = file1Reader.available()/2;
            else count = (file1Reader.available() - 1) / 2;

            while (file1Reader.available() > count) {
                file2Writer.write(file1Reader.read());
            }

            while (file1Reader.available() > 0) {
                file3Writer.write(file1Reader.read());
            }

            file1Reader.close();
            file2Writer.close();
            file3Writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
