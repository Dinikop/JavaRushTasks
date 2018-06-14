package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        String in, out = "";
        while ((in = fileReader.readLine()) != null) {
            out = in.replaceAll("\\.", "!");
            //out = in;
            fileWriter.write(out);
        }
        fileReader.close();
        fileWriter.close();
    }
}
