package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int nums[] = {0, 0, 0};
        nums[0] = Integer.parseInt(r.readLine());
        nums[1] = Integer.parseInt(r.readLine());
        nums[2] = Integer.parseInt(r.readLine());
        int poz = 0;
        int neg = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) poz++;
            if (nums[i] < 0) neg++;
        }

        System.out.println("количество отрицательных чисел: " + neg);
        System.out.println("количество положительных чисел: " + poz);

    }
}
