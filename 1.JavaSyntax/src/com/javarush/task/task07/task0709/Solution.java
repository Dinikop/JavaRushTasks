package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>(5);

        int minLengthString;

        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
        }

        minLengthString = list.get(0).length();

        for (String s : list) {
            if (s.length() < minLengthString) minLengthString = s.length();
        }


//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i).length() < minLengthString) minLengthString = list.get(i).length();
//        }

        for (String str : list) {
            if (str.length() == minLengthString) System.out.println(str);
        }

    }
}
