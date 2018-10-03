package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringBuffer stringBuffer = new StringBuffer();
        Arrays.stream(Dish.values()).forEach(x -> stringBuffer.append(x).append(", "));
        return stringBuffer.toString().substring(0, stringBuffer.lastIndexOf(","));
    }
}
