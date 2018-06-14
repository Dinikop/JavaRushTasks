package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] nums = new int[20];
        nums[0] = Integer.parseInt(reader.readLine());
        maximum = minimum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
            if (nums[i] > maximum) maximum = nums[i];
            if (nums[i] < minimum) minimum = nums[i];
        }

        System.out.println(maximum + " " + minimum);

    }
}
