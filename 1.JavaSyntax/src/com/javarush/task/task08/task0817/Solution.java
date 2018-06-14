package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Королев","Василий");
        map.put("Туполев","Константин");
        map.put("Медведев","Борис");
        map.put("Путин","Борис");
        map.put("Костюченко","Евгений");
        map.put("Евдокимов","Николай");
        map.put("Васильев","Василий");
        map.put("Сидоров","Александр");
        map.put("Петров","Василий");
        map.put("Иванов","Арсений");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код

        ArrayList<String> names = new ArrayList<>();


        for (Map.Entry<String, String> stringStEntry : map.entrySet()) {
            names.add(stringStEntry.getValue());
        }

        ArrayList<String> namesToDelete = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            String currentName = names.get(i);
            for (int j = i+1; j < names.size(); j++) {
                if (currentName.equals(names.get(j))) {
                    if (!namesToDelete.contains(currentName)) namesToDelete.add(currentName);
                }
            }
        }

        for (String s : namesToDelete) {
            removeItemFromMapByValue(map, s);
        }


    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        //ЗАКОММЕНТИ ПРЕЖДЕ ЧАМ ЗАПУСКАТЬ!!!!!!!!!!!!!
//        HashMap<String, String> map = createMap();
//        removeTheFirstNameDuplicates(map);
//
//        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
//            System.out.println(stringStringEntry);
//        }

    }
}
