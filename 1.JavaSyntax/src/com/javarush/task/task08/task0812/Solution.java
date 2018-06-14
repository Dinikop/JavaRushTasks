package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        int maxSequence = 0;
        int currentSequence = 1;
        int input;
        for (int i = 0; i < 10; i++) {
            input = Integer.parseInt(reader.readLine());
            list.add(input);
        }

        for (int i = 1; i < list.size(); i++) {
            if (i == list.size()-1) {
                if (maxSequence < currentSequence) maxSequence = currentSequence + 1;
            }
            if (list.get(i-1).equals(list.get(i))) currentSequence++;
            else {
                if (maxSequence < currentSequence) maxSequence = currentSequence;
                    currentSequence = 1;
            }
        }

        System.out.println(maxSequence);
    }
}