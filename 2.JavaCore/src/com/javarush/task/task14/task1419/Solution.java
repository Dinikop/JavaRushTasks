package com.javarush.task.task14.task1419;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        exceptions.add(new IllegalAccessException());
        exceptions.add(new ClassNotFoundException());

        exceptions.add(new NoSuchMethodException());
        exceptions.add(new NoSuchFieldException());
        exceptions.add(new NoSuchElementException());
        exceptions.add(new FileNotFoundException());
        exceptions.add(new IllegalArgumentException());
        exceptions.add(new ArithmeticException());
        exceptions.add(new ArrayIndexOutOfBoundsException());

    }
}
