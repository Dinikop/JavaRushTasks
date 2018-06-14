package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int maximum = Integer.parseInt(reader.readLine());
        int input;

        for (int i = 1; i < n; i++) {
            input = Integer.parseInt(reader.readLine());
            if (input > maximum) maximum = input;
        }

        //напишите тут ваш код

        System.out.println(maximum);
    }
}
