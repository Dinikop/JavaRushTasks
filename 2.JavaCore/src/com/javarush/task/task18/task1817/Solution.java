package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(args[0]));
        int countSpaces = 0, countChars = 0;
        int input = 0;

        while ((input = reader.read()) != -1){

            if (input == 13 || input == 10) continue; //исключаем служебнные символы
            if (input == 32) ++countSpaces;             //32 - код пробела
            ++countChars;

        }
        reader.close();
        float result = (float) countSpaces / (float) countChars * 100;
        System.out.println(BigDecimal.valueOf(result).setScale(2, BigDecimal.ROUND_CEILING).floatValue()); //округляем через BigDecimal
    }
}
