package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] mass = new ArrayList[3];
        ArrayList<String> mass1 = new ArrayList<>();
        ArrayList<String> mass2 = new ArrayList<>();
        ArrayList<String> mass3 = new ArrayList<>();
        mass1.add("ыкерыкеор");
        mass1.add("йцуцкрнцр");
        mass1.add("варакер");
        mass[0] = mass1;

        mass2.add("ыкервено");
        mass2.add("нглае");
        mass2.add("кен");
        mass[1] = mass2;

        mass3.add("гшдг");
        mass3.add("кер");
        mass3.add("гшщг");
        mass[2] = mass3;

        return mass;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}