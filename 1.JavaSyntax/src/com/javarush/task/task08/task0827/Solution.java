package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) {

        Date currentDate = new Date(date);
        Date beginingOfYear = new Date(date);
        beginingOfYear.setMonth(0);
        beginingOfYear.setDate(1);

        long numberOfDays = (currentDate.getTime() - beginingOfYear.getTime()) / (24 * 60 * 60 * 1000) + 1;

        return numberOfDays % 2 != 0;
    }
}
