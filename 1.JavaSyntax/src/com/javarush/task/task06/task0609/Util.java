package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        int katetX = Math.abs(x1 - x2);
        int katetY = Math.abs(y1 - y2);
        return Math.sqrt((Math.pow(katetX, 2)) + Math.pow(katetY, 2));
    }

    public static void main(String[] args) {

    }
}
