package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Иванов", new Date("JANUARY 1 1980"));
        map.put("Петров", new Date("JANUARY 1 1980"));
        map.put("Сидоров", new Date("JANUARY 1 1980"));
        map.put("Прокопенко", new Date("JANUARY 1 1980"));
        map.put("Улюкаев", new Date("JANUARY 1 1980"));
        map.put("Мутко", new Date("JANUARY 1 1980"));
        map.put("Кирилов", new Date("JANUARY 1 1980"));
        map.put("Лужко", new Date("JANUARY 1 1980"));
        map.put("Медведев", new Date("JANUARY 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();

            int month = pair.getValue().getMonth();
            if (month >= 5 && month <= 7) iterator.remove();
        }

    }

    public static void main(String[] args) {
//        HashMap<String, Date> map = createMap();
//        removeAllSummerPeople(map);
//
//        for (Map.Entry<String, Date> pair : map.entrySet()) {
//            System.out.println(pair);
//        }


    }
}
