package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        HashMap<Integer, Integer> map = new HashMap<>();

        int symbol;
        while ((symbol = fileReader.read()) != -1) {
            if (map.containsKey(symbol)) {
                map.replace(symbol, map.get(symbol) + 1);
            }
            else map.put(symbol, 1);
        }
        fileReader.close();
        TreeSet<Integer> set = new TreeSet<>(map.keySet());

        for (Integer integer :set) {
            System.out.println((char)((int)integer) + " " + map.get(integer));
        }


//        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
//            System.out.println((char)((int) entry.getKey()) + " " + entry.getValue());
//        }

    }
}
