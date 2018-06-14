package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();

        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);
        int num3 = Integer.parseInt(s3);

        if ((num1 == num2) && (num2 == num3)) {
            System.out.println(num1 + " " + num2 + " " + num3);
        }
        else {
            if (num1 == num2) System.out.println(num1 + " " + num2);
            if (num1 == num3) System.out.println(num1 + " " + num3);
            if (num2 == num3) System.out.println(num2 + " " + num3);
        }
    }
}