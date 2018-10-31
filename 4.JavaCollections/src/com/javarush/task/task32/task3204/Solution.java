package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.ThreadLocalRandom;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        char[] password = new char[8];

        password[0] = generateDigit();
        password[1] = generateLowerCaseLetter();
        password[2] = generateUpperCaseLetter();

        for (int i = 3; i < password.length; i++) {
            password[i] = generateValidSymbol();
        }

        shakeArray(password);

        StringReader stringReader = new StringReader(new String(password));
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        try {
            int readByte;
            while ((readByte = stringReader.read()) != -1)
            result.write(readByte);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static char generateDigit() {
        return (char) ThreadLocalRandom.current().nextInt(48, 57 + 1);
    }

    private static char generateUpperCaseLetter() {
        return (char) (char) ThreadLocalRandom.current().nextInt(65, 90 + 1);
    }

    private static char generateLowerCaseLetter() {
        return (char) (char) ThreadLocalRandom.current().nextInt(97, 122 + 1);
    }

    private static char generateValidSymbol() {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0: return generateDigit();
            case 1: return  generateUpperCaseLetter();
            default: return generateLowerCaseLetter();
        }
    }

    private static void shakeArray(char[] arr) {
        int a, b;
        char temp;

        for (int i = 0; i < 100; i++) {
            a = ThreadLocalRandom.current().nextInt(8);
            b = ThreadLocalRandom.current().nextInt(8);

            temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}