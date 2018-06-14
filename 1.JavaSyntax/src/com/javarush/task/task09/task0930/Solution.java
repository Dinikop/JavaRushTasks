package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> digits = new ArrayList<>();
        //формируем из исходного массива два массива - со строками и с цифрами отдельно
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                digits.add(Integer.parseInt(array[i]));
            }
            else strings.add(array[i]);
        }

        //сортируем массив с числами пузырьковой сортировкой
        for (int i = 0; i < digits.size(); i++) {
            for (int j = 1; j < digits.size(); j++) {
                int current = digits.get(j);
                int previous = digits.get(j-1);
                if (current > previous) {
                    digits.remove(j-1);
                    digits.add(j-1, current);
                    digits.remove(j);
                    digits.add(j, previous);
                }
            }
        }

        //сортируем массив со строками
        for (int i = 0; i < strings.size(); i++) {
            for (int j = 1; j < strings.size(); j++) {
                String current = strings.get(j);
                String previous = strings.get(j-1);
                if (isGreaterThan(previous, current)) {
                    strings.remove(j-1);
                    strings.add(j-1, current);
                    strings.remove(j);
                    strings.add(j, previous);
                }
            }
        }

        //формируем окончательный массив
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = digits.get(0).toString();
                digits.remove(0);
            }
            else {
                array[i] = strings.get(0);
                strings.remove(0);
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
