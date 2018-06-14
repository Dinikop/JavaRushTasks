package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(nameReader.readLine())));
        nameReader.close();

        String s;
        while ((s = fileReader.readLine()) != null) {
            if (s.startsWith(args[0] + " ")) System.out.println(s);
        }
        fileReader.close();
    }
}
