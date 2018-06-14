package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream sysOut = System.out;
        ByteArrayOutputStream myOutputStream = new ByteArrayOutputStream();
        PrintStream myOut = new PrintStream(myOutputStream);
        System.setOut(myOut);
        testString.printSomething();
        System.setOut(sysOut);
        String[] strings = myOutputStream.toString().split(" ");

        int a, b, c = 0;
        a = Integer.parseInt(strings[0]);
        b = Integer.parseInt(strings[2]);

        switch (strings[1]) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case  "*":
                c = a * b;
                break;
        }

        System.out.println(a + " " + strings[1] + " " + b  + " = " + c);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

