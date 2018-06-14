package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static
    {
        labels.put(1.24, "a");
        labels.put(1.25, "b");
        labels.put(1.26, "c");
        labels.put(1.27, "d");
        labels.put(1.28, "f");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
