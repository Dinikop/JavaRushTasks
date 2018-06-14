package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int str=1, stb =1;
        while (str <= 10) {
            while (stb <= 10) {
                System.out.print(str * stb + " ");
                stb++;
            }
            System.out.println();
            str++;
            stb = 1;
        }
    }
}
