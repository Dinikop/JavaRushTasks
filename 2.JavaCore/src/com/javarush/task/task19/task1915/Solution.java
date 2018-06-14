package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        PrintStream sysOut = System.out;
        ByteArrayOutputStream myOutputStream = new ByteArrayOutputStream();
        PrintStream myOut = new PrintStream(myOutputStream);
        System.setOut(myOut);
        testString.printSomething();
        System.setOut(sysOut);

        FileOutputStream fileWriter = new FileOutputStream(fileName);
        fileWriter.write(myOutputStream.toByteArray());
        fileWriter.close();
        System.out.println(myOutputStream.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

