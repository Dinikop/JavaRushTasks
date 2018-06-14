package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();

        map.put("Королев","Василий");
        map.put("Туполев","Константин");
        map.put("Медведев","Борис");
        map.put("Путин","Виктор");
        map.put("Костюченко","Евгений");
        map.put("Евдокимов","Николай");
        map.put("Васильев","Владислав");
        map.put("Сидоров","Александр");
        map.put("Петров","Василий");
        map.put("Иванов","Арсений");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey().equals(lastName)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        HashMap<String, String> map = createMap();
//        int countNames = getCountTheSameFirstName(map, "Василий");
//        int countLastName = getCountTheSameLastName(map, "Иванов");
//        System.out.println(countNames);
//        System.out.println(countLastName);
    }
}
