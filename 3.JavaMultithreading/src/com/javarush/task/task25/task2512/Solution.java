package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> list = new ArrayList<>();
        list.add(e);
        Throwable cause = e;
        while ((cause = cause.getCause()) != null) {
            list.add(cause);
        }

        for (int i = list.size() - 1; i >= 0 ; i--) {
            System.out.println(list.get(i));
        }
//        System.out.println(e.getCause().toString().substring(e.getCause().toString().lastIndexOf('.') + 1));
    }

    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                throw new RuntimeException("ABC", new Exception("DEF", new IllegalAccessException("GHI")));
            }
        };
        t.setUncaughtExceptionHandler(new Solution());
        t.start();

    }
}
