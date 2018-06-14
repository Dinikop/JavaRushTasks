package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> divideBy3 = new ArrayList<>();
        ArrayList<Integer> divideBy2 = new ArrayList<>();
        ArrayList<Integer> notDivide = new ArrayList<>();



        for (int i = 0; i < 20; i++) {
            input.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < input.size(); i++) {
            if (/*(double)*/(input.get(i) % 2) == 0) divideBy2.add(input.get(i));
            if ((double)(input.get(i) % 3) == 0) divideBy3.add(input.get(i));
            if ((double)(input.get(i) % 2) != 0 && (double)(input.get(i) % 3) != 0) notDivide.add(input.get(i));
        }

        printList(input);
        System.out.println();
        printList(divideBy3);
        System.out.println();
        printList(divideBy2);
        System.out.println();
        printList(notDivide);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}
