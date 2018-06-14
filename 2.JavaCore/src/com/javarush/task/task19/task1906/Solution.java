package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        reader.close();
        int input, count = 1;
        while ((input = fileReader.read()) != -1) {
            if (count % 2 == 0) {
                fileWriter.write(input);
            }
            count++;
        }

        fileReader.close();
        fileWriter.close();
    }
}
