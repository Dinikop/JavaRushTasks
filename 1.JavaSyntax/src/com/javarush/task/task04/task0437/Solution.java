package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int j = 1;
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < j; k++) {
                System.out.print(8);
            }
            j++;
            System.out.println();
        }
    }
}
