package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>(5);
        list.add("dfg");
        list.add("reg");
        list.add("gewg");
        list.add("erge");
        list.add("gerg");

        System.out.println(list.size());

        for (String o : list) {
            System.out.println(o);
        }

    }
}
