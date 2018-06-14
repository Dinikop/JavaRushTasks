package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        strings = new ArrayList<String>();

        int maxLengthString = 0;
        String input;

        for (int i = 0; i < 5; i++) {
            input = reader.readLine();
            strings.add(input);
            if (input.length() > maxLengthString) maxLengthString = input.length();
        }

        for (String str : strings) {
            if (str.length() == maxLengthString) System.out.println(str);
        }

    }
}
