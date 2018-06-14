package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int currentInput;
        int count = 0;
        int sum = 0;

        while (true) {
            currentInput = Integer.parseInt(reader.readLine());
            if (currentInput == -1) {
                System.out.println((float) sum / count);
                break;
            }

            sum += currentInput;
            count++;
        }
    }
}

