package com.javarush.task.task18.task1803;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileReader = new FileInputStream(fileName);
        HashMap<Integer, Integer> map = new HashMap<>();
        int readByte;
        int frequency;

        while (fileReader.available() > 0) {
            readByte = fileReader.read();
            if (map.containsKey(readByte)) {
                frequency = map.get(readByte);
                map.replace(readByte, ++frequency);
            }
            else map.put(readByte, 1);
        }
        fileReader.close();
//        for (HashMap.Entry entry : map.entrySet()) {
//            System.out.print(entry.getKey() + " " + entry.getValue() + "\n");
//        }
//        System.out.println("==============");
        int max = Collections.max(map.values());
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                System.out.print(entry.getKey() + " ");
            }

        }

    }
}
