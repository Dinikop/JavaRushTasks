package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        Pattern p = Pattern.compile("\\b\\d+\\b");

        String in = "";
        StringBuilder out;
        while ((in = fileReader.readLine()) != null) {
            Matcher m = p.matcher(in);
            out = new StringBuilder();
            while (m.find()) {
                out.append(in.substring(m.start(), m.end()));
                out.append(" ");
            }
            fileWriter.write(out.toString());
        }
        fileReader.close();
        fileWriter.close();
    }
}
