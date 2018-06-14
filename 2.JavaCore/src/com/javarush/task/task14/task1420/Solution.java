package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;

import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = 0;
        int y = 0;

            x = Integer.parseInt(reader.readLine());
            y = Integer.parseInt(reader.readLine());

        if (x <= 0 || y <= 0) {
            throw new NumberFormatException();
        }

        int a,b;

        if (x > y) {
            a = x;
            b = y;
        }
        else {
            a = y;
            b = x;
        }

        int i = 1;
        int divider;


        while (true) {
            if ( b % i == 0 ) {
                divider = b / i;
                if (a % divider == 0) break;
                else i++;
            }
            else i++;
        }

        System.out.println(divider);
    }
}
