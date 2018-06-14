package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] array = {13, 8, 15, 5, 17};
//        array = sort(array);
//
//        for (int i :array) {
//            System.out.print(i + " ");
//        }

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int median;
        if (array.length % 2 == 0) {
            median = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
//            System.out.println(array[array.length / 2 - 1]);
//            System.out.println(array[array.length / 2]);
        }
        else {
            median = array[array.length / 2];
        }
//        System.out.println(median);

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (Math.abs(array[j-1] - median) > Math.abs(array[j] - median)) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }


}
