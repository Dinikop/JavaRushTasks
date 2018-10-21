package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumerationSystemType._16, "6df");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumerationSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._16);
        System.out.println(result);    //expected abcdefabcdef

        number = new Number(NumerationSystemType._2, "0101");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        //напишите тут ваш код

//        String[] allDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        char[] allDigits = "0123456789abcdef".toCharArray();


        //============блок проверки=============================
        boolean result = true;
        for (char c :number.getDigit().toLowerCase().toCharArray()) {
            boolean contained = false;
            for (int i = 0; i < number.getNumerationSystem().getNumerationSystemIntValue(); i++) {
                if (c == allDigits[i]) contained = true;
            }
            result = result && contained;
        }
        if (!result) throw new NumberFormatException();
        //============конец блока проверки=============================

        if (number.getNumerationSystem().getNumerationSystemIntValue() == expectedNumerationSystem.getNumerationSystemIntValue()) return number;

        return new Number(expectedNumerationSystem,
                new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue()).toString(expectedNumerationSystem.getNumerationSystemIntValue()));

    }
}
