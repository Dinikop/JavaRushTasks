package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in ));
        int[] arrayBig = new int[20];

        int[] arraySmall1 = new  int[10];
        int[] arraySmall2 = new  int[10];

        for (int i = 0; i < arrayBig.length; i++) {
            arrayBig[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < arrayBig.length; i++) {
            if (i < arrayBig.length / 2) {
                arraySmall1[i] = arrayBig[i];
            }
            else  {
                arraySmall2[i-10] = arrayBig[i];
            }
        }

        for (int i : arraySmall2) {
            System.out.println(i);
        }

    }
}
