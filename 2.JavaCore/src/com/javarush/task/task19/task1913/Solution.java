package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream sysOut = System.out;
        ByteArrayOutputStream myOutputStream = new ByteArrayOutputStream();
        PrintStream myOut = new PrintStream(myOutputStream);
        System.setOut(myOut);
        testString.printSomething();
        System.setOut(sysOut);

        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(myOutputStream.toString());

        StringBuilder out = new StringBuilder();
        while (m.find()) {
            out.append(myOutputStream.toString().substring(m.start(), m.end()));
        }
        System.out.println(out);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
