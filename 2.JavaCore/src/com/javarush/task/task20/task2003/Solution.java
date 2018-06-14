package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream is = new FileInputStream(reader.readLine());
        load(is);
        reader.close();
        is.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, "my properties");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        properties.putAll((Map) prop);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        try {
            s.fillInPropertiesMap();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Map.Entry entry :properties.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
