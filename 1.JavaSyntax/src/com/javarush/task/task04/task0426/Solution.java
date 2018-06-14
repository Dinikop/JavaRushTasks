package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(r.readLine());

        if (num1 > 0 && num1 % 2 ==0) System.out.println("положительное четное число");
        if (num1 > 0 && num1 % 2 !=0) System.out.println("положительное нечетное число");
        if (num1 < 0 && num1 % 2 ==0) System.out.println("отрицательное четное число");
        if (num1 < 0 && num1 % 2 !=0) System.out.println("отрицательное нечетное число");
        if (num1 == 0) System.out.println("ноль");
    }
}
