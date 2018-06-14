package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> dateMap = new HashMap<>();

        dateMap.put("January", 0);
        dateMap.put("February", 1);
        dateMap.put("March", 2);
        dateMap.put("April", 3);
        dateMap.put("May", 4);
        dateMap.put("June", 5);
        dateMap.put("July", 6);
        dateMap.put("August", 7);
        dateMap.put("September", 8);
        dateMap.put("October", 9);
        dateMap.put("November", 10);
        dateMap.put("December", 11);

        String input = reader.readLine();

        for (Map.Entry<String, Integer> pair : dateMap.entrySet()) {
            if (pair.getKey().equals(input)) {
                System.out.println(pair.getKey() + " is " + (pair.getValue()+1) + " month");
            }
        }

    }
}
