package com.javarush.task.task05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Cat cat1 = new Cat("Vasya", 3, 8, 15);
        Cat cat2 = new Cat("Pushok", 5, 10, 12);
        Cat cat3 = new Cat("Rizhik", 1, 2, 5);

    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}