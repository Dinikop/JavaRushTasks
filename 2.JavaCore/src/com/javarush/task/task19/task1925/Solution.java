package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s= reader.readLine()) != null) {
            String[] strings = s.split(" ");
            for (String s1 :strings) {
                if (s1.length() > 6) {
                    sb.append(s1);
                    sb.append(",");
                }
            }
        }
        reader.close();
        writer.write(sb.toString().substring(0, sb.lastIndexOf(",")));
        writer.close();
    }
}
