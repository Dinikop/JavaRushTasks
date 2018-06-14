package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        String pattern = "[\\w]*[\\d]+[\\w]*";
        String s;
        StringBuilder out = new StringBuilder();
        while ((s = fileReader.readLine()) != null){
            String[] strings = s.split(" ");
            for (String s1 :strings) {
                if (s1.matches(pattern)) {
                    out.append(s1);
                    out.append(" ");
                }
            }

        }
        fileWriter.write(out.toString());

        fileWriter.close();
    }
}
