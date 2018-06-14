package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        int count = 0;

        String s;
        while ((s = fileReader.readLine()) != null) {
            String[] strings = s.split(" ");
            count = 0;
            for (String s1 :strings) {
                for (String s2 :words) {
                    if (s1.equals(s2)) count++;
                }
            }
            if (count == 2) System.out.println(s);
        }
        fileReader.close();
    }
}
