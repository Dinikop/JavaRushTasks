package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        byte[] fileImage1 = new byte[fileInputStream1.available()];
        fileInputStream1.read(fileImage1);
        fileInputStream1.close();

        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName1);
        FileInputStream fileInputStream2 = new FileInputStream(fileName2);

        byte[] fileImage2 = new byte[fileInputStream2.available()];
        fileInputStream2.read(fileImage2);
        fileInputStream2.close();

        fileOutputStream1.write(fileImage2);
        fileOutputStream1.write(fileImage1);
        fileOutputStream1.close();
    }
}
