package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        StringBuilder words = new StringBuilder();
        int input;
        while ((input = fileReader.read()) != -1) words.append((char) input);
        fileReader.close();
        StringBuilder result = getLine(words.toString().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder result = new StringBuilder();
        if (words.length == 0) return result;
        String[] wordsCopy = Arrays.copyOf(words, words.length);
        Arrays.sort(wordsCopy);
        for (int i = 0; i < wordsCopy.length; i++) {
            if (wordsCopy[i].isEmpty()) continue;
            if (i == 0) {
                result.append(wordsCopy[0]).append(" ");
                wordsCopy[0] = "";
            }
            char lastChar = result.charAt(result.length() - 2);
            for (int j = 0; j < wordsCopy.length; j++) {
                if (wordsCopy[j].isEmpty()) continue;
                if (wordsCopy[j].toLowerCase().charAt(0) == lastChar) {
                    result.append(wordsCopy[j]).append(" ");
                    wordsCopy[j] = "";
                    break;
                }
            }
        }

        for (String s :wordsCopy) {
            if (!s.isEmpty()) result.append(s).append(" ");
        }

        if (result.charAt(result.length() - 1) == ' ') result.deleteCharAt(result.length() - 1);

        return result;
    }
}
