package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

//        ArrayList<Character> list = new ArrayList<>();
//        for (int i = 48; i < 58; i++) {
//            list.add((char) i);
//        }
//        for (int i = 65; i < 91; i++) {
//            list.add((char) i);
//        }

        char[] validCharacters = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ".toCharArray();
//        list.toArray(validCharacters);

        int numerationSystem = 2;
        boolean badData = false;

        try {
            for (Character character :args[0].toUpperCase().toCharArray()) {
                int ascii = character;

                    int currentKey = 0;
                    for (int i = 2; i < validCharacters.length; i++) {
                        currentKey = Arrays.binarySearch(validCharacters, character);
                        if (currentKey < 0) {
                            System.out.println("incorrect");
                            badData = true;
                            break;
                        }
                        currentKey++;
                        numerationSystem = Integer.max(currentKey, numerationSystem);
                    }
            }
        } catch (Exception e) {

        }

        if (!badData) System.out.println(numerationSystem);


    }
}