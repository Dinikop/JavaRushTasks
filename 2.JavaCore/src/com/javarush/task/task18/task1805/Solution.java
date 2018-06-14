package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileReader = new FileInputStream(reader.readLine());
        reader.close();


        ArrayList<Integer> list = new ArrayList<>();
        while (fileReader.available() > 0){
            int readByte = fileReader.read();
            if (list.contains(readByte)) continue;
            else list.add(readByte);
        }
        fileReader.close();
        Collections.sort(list);


        for (Integer i :list) {
            System.out.print(i + " ");
        }

    }
}
