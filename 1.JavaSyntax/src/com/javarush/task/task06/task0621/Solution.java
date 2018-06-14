package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Cat grFather = new Cat(reader.readLine());
        Cat grMother = new Cat(reader.readLine());
        Cat father = new Cat(reader.readLine(), grFather);
        Cat mother = new Cat(grMother, reader.readLine());
        Cat son = new Cat(reader.readLine(), mother, father);
        Cat daughter = new Cat(reader.readLine(), mother, father);

        System.out.println(grFather);
        System.out.println(grMother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(daughter);


//        String motherName = reader.readLine();
//        Cat catMother = new Cat(motherName);
//
//        String daughterName = reader.readLine();
//        Cat catDaughter = new Cat(daughterName, catMother);
//
//        System.out.println(catMother);
//        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(Cat mother, String name) {
            this.name = name;
            this.mother = mother;
        }

        Cat(String name, Cat father) {
            this.name = name;
            this.father = father;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
        }



        @Override
        public String toString() {
            if (mother == null && father == null)
                return "Cat name is " + name + ", no mother, no father";
            else if (father == null)
                return "Cat name is " + name + ", mother is " + mother.name + ", no father";
            else if (mother == null)
                return "Cat name is " + name + ", no mother, father is " + father.name;
            else
                return "Cat name is " + name + ", mother is " + mother.name + ", father is " + father.name;
        }
    }

}
