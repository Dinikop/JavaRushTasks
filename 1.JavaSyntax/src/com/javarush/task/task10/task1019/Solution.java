package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

/*        int id = Integer.parseInt(reader.readLine());
        String name = reader.readLine();

        System.out.println("Id=" + id + " Name=" + name);*/

        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            String inputVal = reader.readLine();
            if (inputVal.equals("")) break;
            int val = Integer.parseInt(inputVal);
            String key = reader.readLine();
            map.put(key, val);
        }

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getValue() + " " + pair.getKey());
        }

    }
}
