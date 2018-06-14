package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Королев",320);
        map.put("Туполев",540);
        map.put("Медведев",800);
        map.put("Путин",1200);
        map.put("Костюченко",250);
        map.put("Евдокимов",500);
        map.put("Васильев",800);
        map.put("Сидоров",1200);
        map.put("Петров",200);
        map.put("Иванов",100);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copyMap = new HashMap<>(map);

        for (Map.Entry<String, Integer> entry : copyMap.entrySet()) {
            if (entry.getValue() < 500) {
                map.remove(entry.getKey());
            }
        }

    }

    public static void main(String[] args) {
//ЗАКОМЕНТИ ПРЕЖДЕ ЧЕМ ОТПРАВЛЯТЬ НА ПРОВЕРКУ
//        HashMap<String, Integer> map = createMap();
//        removeItemFromMap(map);
//
//        for (Map.Entry<String, Integer> pair : map.entrySet()){
//            System.out.println(pair);
//        }


    }
}