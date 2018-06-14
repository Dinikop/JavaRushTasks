package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        for (String s : list) {
            if (s.length() == minLength(list) || s.length() == maxLength(list)) {
                System.out.println(s);
                break;
            }
        }


    }
    private static int minLength (ArrayList<String> list) {
        int min = list.get(0).length();
        for (String s : list) {
            if (s.length() < min) min = s.length();
        }
        return min;
    }

    private static int maxLength (ArrayList<String> list) {
        int max = 0;
        for (String s : list) {
            if (s.length() > max) max = s.length();
        }
        return max;
    }
}
