package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long position = Long.parseLong(args[1]);
        String expectedText = args[2];
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        raf.seek(position);
        byte[] readingBytes = new byte[expectedText.getBytes().length];
        raf.read(readingBytes, 0, expectedText.getBytes().length);
        String actuallyString = new String(readingBytes);

        raf.seek(raf.length());
        if (expectedText.equals(actuallyString)) raf.write("true".getBytes());
        else raf.write("false".getBytes());

    }
}
