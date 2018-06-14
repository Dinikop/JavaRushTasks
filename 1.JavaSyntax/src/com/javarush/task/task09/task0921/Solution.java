package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }



    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        try {
            int input;
            while (true) {
                input = Integer.parseInt(reader.readLine());
                list.add(input);
            }
        } catch (NumberFormatException e) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

