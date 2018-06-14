package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();

        StringBuilder fileImage = new StringBuilder();

        int input = 0;
        while ((input = fileReader.read()) != -1) {
            fileImage.append((char) input);
        }
        fileReader.close();
        Pattern p = Pattern.compile("\\bworld\\b");
        Matcher m = p.matcher(fileImage);
        int worldCount = 0;
        while (m.find()) {
            worldCount++;
        }
        System.out.println(worldCount);
    }
}
