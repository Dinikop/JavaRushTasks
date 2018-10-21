package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        int radix = 0;
        String number;
        if (s.indexOf("0x") == 0) {
            radix = 16;
            number = s.substring(2);
        } else if (s.indexOf("0b") == 0) {
            radix = 2;
            number = s.substring(2);
        } else if (s.indexOf("0") == 0) {
            radix = 8;
            number = s.substring(1);
        } else {
            radix = 10;
            number = s;
        }
        return String.valueOf(Integer.parseInt(number, radix));
    }

}
