package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ConsoleHelper {
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {

        String string = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        string = bufferedReader.readLine();
        return string;
    }


    public static List<Dish> getAllDishesForOrder() throws IOException {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        ConsoleHelper.writeMessage("Введите имя блюда для его заказа: ");
        List<Dish> dishes = new LinkedList<>();
        while (true) {
            String input = ConsoleHelper.readString();
            if (input.equals("exit")) break;
            try {
                dishes.add(Dish.valueOf(input));
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("Такого блюда нет в меню!");
            }

        }
        return dishes;
    }
}
