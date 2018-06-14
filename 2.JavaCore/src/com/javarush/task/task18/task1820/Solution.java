package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        FileWriter fileWriter = new FileWriter(reader.readLine(), false);
        reader.close();

        String s;
        StringBuilder out = new StringBuilder();
        while ((s = fileReader.readLine()) != null){
            String[] strings = s.split(" ");
            for (int i = 0; i < strings.length; i++) {
                Long l = Math.round(Double.parseDouble(strings[i]));
                out.append(l);
                out.append(" ");
            }
            fileWriter.write(out.toString());
        }
        fileWriter.flush();
        fileReader.close();
        fileWriter.close();


    }

}
