package com.javarush.task.task22.task2202;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        String s = "";
        try {
            s = getPartOfString("Амиго и Диего друзья!");
        } catch (Exception e) {

        }
        System.out.println(s);
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        String[] strings = string.split(" ");
        if (strings.length < 5) throw new TooShortStringException();
        StringBuilder result = new StringBuilder();
//        int spaceCount = 0;
        for (int i = 0; i < strings.length; i++) {
//            if (strings[i].equals(" ")) spaceCount++;
            if (i >=1 && i <=4) {
                result.append(strings[i]);
                result.append(" ");
            }
        }

        return result.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {

    }
}
