package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        TreeMap<String, FileInputStream> map = new TreeMap<>();
        TreeSet<String> fileNames = new TreeSet<>();
        String fileName = "";

        while (!(fileName = reader.readLine()).equals("end")) {
            fileNames.add(fileName);
        }

        String fileNameForWrite = fileNames.first().substring(0, fileNames.first().lastIndexOf("."));

        FileOutputStream fileOutputStream = new FileOutputStream(fileNameForWrite);
        byte[] buffer;

        for (String s :fileNames) {
            FileInputStream fileInputStream = new FileInputStream(s);
            buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileInputStream.close();
        }

        fileOutputStream.close();
    }
}
