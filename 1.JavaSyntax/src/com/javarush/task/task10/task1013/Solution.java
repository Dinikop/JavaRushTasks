package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private int age;
        private String name;
        private String profession;
        private int heigth;
        private boolean relationship;
        private String phone;

        public Human (){}
        public Human(int age) {}
        public Human(int age, String name) {}
        public Human(int age, String name, String profession) {}
        public Human(int age, String name, String profession, int heigth) {}
        public Human(int age, String name, String profession, int heigth, boolean relationship) {}
        public Human(int age, String name, String profession, int heigth, boolean relationship, String phone) {}
        public Human(int age, int heigth) {}
        public Human(int age, int heigth, String name) {}
        public Human(int age, int heigth, String name, boolean relationship) {}
    }
}
