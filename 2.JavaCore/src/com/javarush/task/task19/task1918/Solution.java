package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();

        StringBuilder fileImage = new StringBuilder();

        int input;
        while ((input = fileReader.read()) != -1) {
            if (input == 10 || input == 13) continue;
            fileImage.append((char) input);
        }
        fileReader.close();
        //System.out.println(fileImage);

        String pattern = "(<" + args[0] + "\\W)|(<\\/" + args[0] + ">)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(fileImage);

        int nesting = 0;

        ArrayList<Integer> indices = new ArrayList<>();

        while (m.find()) {
            if (m.group().equals("<" + args[0] + " ") || m.group().equals("<" + args[0] + ">")) {
                indices.add(m.start());
                nesting++;
            }
            if (m.group().equals("</" + args[0] + ">")) {
                nesting--;
                indices.add(m.end());
                if (nesting == 0) {
                    for (int i = 0, j = indices.size() - 1; i < indices.size()/2; i++, j--) {
                        System.out.println(fileImage.substring( indices.get(i) , indices.get(j) ));
                    }
                    indices.clear();
                }
            }
        }
    }
}
