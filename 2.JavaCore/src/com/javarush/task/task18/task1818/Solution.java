package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader stringReader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fileOutputStream = new FileOutputStream(stringReader.readLine());
        FileInputStream fileInputStream2 = new FileInputStream(stringReader.readLine());
        FileInputStream fileInputStream3 = new FileInputStream(stringReader.readLine());
        stringReader.close();

        while (fileInputStream2.available() > 0){
            fileOutputStream.write(fileInputStream2.read());
        }
        fileInputStream2.close();

        while (fileInputStream3.available() > 0) {
            fileOutputStream.write(fileInputStream3.read());
        }

        fileInputStream3.close();
        fileOutputStream.close();
    }
}
