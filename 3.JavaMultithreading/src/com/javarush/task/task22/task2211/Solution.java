package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fin = new FileInputStream(args[0]);
             FileOutputStream fos = new FileOutputStream(args[1])) {
            byte[] input = new byte[fin.available()];
            fin.read(input);

            String s = new String(input, Charset.forName("Windows-1251"));
            byte[] out = s.getBytes(Charset.forName("UTF-8"));
            fos.write(out);
        }


    }
}
