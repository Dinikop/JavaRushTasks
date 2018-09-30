package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString() {
        StringBuffer stringBuffer = new StringBuffer();
        Arrays.stream(Dish.values()).forEach(x -> stringBuffer.append(x).append(", "));
        return stringBuffer.toString().substring(0, stringBuffer.lastIndexOf(","));
    }
}
