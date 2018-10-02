package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Order {

    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {

        if (dishes.isEmpty()) return "";
        else {
            String dishesToString = Arrays.toString(dishes.toArray()).replaceAll("(\\[|\\])", "");
            return String.format("Your order: [%s] of %s", dishesToString, tablet);
        }
    }
}
