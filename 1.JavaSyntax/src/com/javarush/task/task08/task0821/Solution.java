package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Королев","Василий");
        map.put("Туполев","Константин");
        map.put("Медведев","Борис");
        map.put("Путин","Борис");
        map.put("Костюченко","Евгений");
        map.put("Евдокимов","Николай");
        map.put("Васильев","Василий");
        map.put("Иванов","Александр");
        map.put("Петров","Василий");
        map.put("Иванов","Арсений");


        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
