package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        ArrayList<Long> list = new ArrayList<>();
        long n = 0;


        for (long i = 1; i <= N; i++) {
            n = 0;
            byte[] numerals = getNumeralsFromNumber(i);
            for (int j = numerals.length - 1; j >= 0; j--) {
                n += Math.pow(numerals[j], numerals.length);
                if (n > i) break;
            }
            if (n == i) list.add(n);
//            if ((i % 10_000_000) == 0) System.out.println(i);
        }
        result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }


        return result;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //=======================================================
        long[] numbers = getNumbers(1_000_000);
        //=======================================================
        long finishTime = System.currentTimeMillis();
        System.out.println("\nвремя работы " + (finishTime-startTime) + "мсек.");
        System.out.println("Объем памяти " + (Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()) / 1048576 + "Мб");


        for (long l :numbers) {
            System.out.print(l + " ");
        }

    }

    private static byte[] getNumeralsFromNumber(long number) {
        byte[] result = new byte[String.valueOf(number).length()];
        for (int i = 0; number > 0; i++) {
            result[i] = (byte) (number % 10);
            number /= 10;
        }
        Arrays.sort(result);
        return result;
    }
}
