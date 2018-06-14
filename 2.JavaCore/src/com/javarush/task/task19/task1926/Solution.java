package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        String s;
        StringBuffer sb;
        while ((s = fileReader.readLine()) != null) {
            sb = new StringBuffer(s);
            System.out.println(sb.reverse());
        }
        fileReader.close();
    }
}
