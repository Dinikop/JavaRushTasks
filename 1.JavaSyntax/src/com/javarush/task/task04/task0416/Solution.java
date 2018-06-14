package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        double t1 = Double.parseDouble(s);

        double t;

        if (t1 >= 5) {
            t = t1 - Math.floor(t1/5) * 5; //здесь закопана вся соль ;)
        }
        else t = t1;



        if (t >= 0 && t < 3 || t == 5) System.out.println("зеленый");
        if (t >= 3 && t < 4) System.out.println("желтый");
        if (t >= 4 && t < 5) System.out.println("красный ");
    }
}