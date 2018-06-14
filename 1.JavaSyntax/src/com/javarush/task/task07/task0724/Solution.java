package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Human grFather1 = new Human("Василий", true, 60);
        Human grFather2 = new Human("Михаил", true, 61);
        Human grMother1 = new Human("Раиса", false, 58);
        Human grMother2 = new Human("Зинаида", false, 59);

        Human father = new Human("Николай", true, 45, grFather1, grMother1);
        Human mother = new Human("Лида", false, 40, grFather2, grMother2);

        Human son1 = new Human("Борис", true, 15, father, mother);
        Human daugthter = new Human("Ольга", false, 12, father, mother);
        Human son2 = new Human("Борис", true, 5, father, mother);

        System.out.println(grFather1);
        System.out.println(grFather2);
        System.out.println(grMother1);
        System.out.println(grMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(daugthter);

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















