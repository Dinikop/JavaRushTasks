package com.javarush.task.task04.task0428;

/* 
Положительное число
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
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) j++;
        }

        System.out.println(j);
    }
}
