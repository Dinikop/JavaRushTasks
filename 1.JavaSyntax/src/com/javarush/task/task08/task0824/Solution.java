package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> ch = new ArrayList<>();

        Human son1 = new Human("Михаил", true, 10, ch);
        Human son2 = new Human("Вадим", true, 7, ch);
        Human daughter = new Human("Милена", false, 5, ch);

        ArrayList<Human> childrens = new ArrayList<>();
        childrens.add(son1);
        childrens.add(son2);
        childrens.add(daughter);

        Human father = new Human("Олег", true, 35, childrens);
        Human mother = new Human("Мария", false, 30, childrens);

        ArrayList<Human> fatherChild = new ArrayList<>();
        fatherChild.add(father);
        ArrayList<Human> motherChild = new ArrayList<>();
        motherChild.add(mother);

        Human grFather1 = new Human("Борис", true, 52, motherChild);
        Human grMother1 = new Human("Ольга", false, 50, motherChild);

        Human grFather2 = new Human("Николай", true, 65, fatherChild);
        Human grMother2 = new Human("Василиса", false, 60, fatherChild);

        System.out.println(grFather1);
        System.out.println(grFather2);
        System.out.println(grMother1);
        System.out.println(grMother2);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(daughter);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;

        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
