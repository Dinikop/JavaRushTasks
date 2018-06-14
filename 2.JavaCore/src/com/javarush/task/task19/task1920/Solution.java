package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String input;
        TreeMap<String, Double> map = new TreeMap<>();

        while ((input = fileReader.readLine()) != null) {
            String[] strings = input.split(" ");
            double value = Double.parseDouble(strings[1]);
            if (map.containsKey(strings[0])) {
                map.replace(strings[0], map.get(strings[0]) + value);
            }
            else map.put(strings[0], value);
        }
        fileReader.close();

        Double max = Collections.max(map.values());

        for (Map.Entry<String, Double> entry :map.entrySet()) {
            if (entry.getValue().equals(max)) {
                System.out.println(entry.getKey());
            }
        }
    }
}
