package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(r.readLine());

        if (num1 >= 1 && num1 <= 999) System.out.println(parity(num1) + " " + razr(num1) + " число");

    }

    public static String razr(int num) {
        if (Math.ceil(num / 100) != 0) return "трехзначное";
        else if (Math.ceil(num /10) != 0) return "двузначное";
        else return "однозначное";
    }

    public static String parity(int num) {
        if (num % 2 == 0) return "четное";
        else return "нечетное";
    }

}
