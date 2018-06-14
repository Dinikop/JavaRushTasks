package com.javarush.task.task19.task1921;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String input;
        StringBuilder name;


        while ((input = fileReader.readLine()) != null) {
            String[] strings = input.split(" ");
            name = new StringBuilder();
            for (int i = 0; i < strings.length - 3; i++) {
                name.append(strings[i]);
                if (i != strings.length - 4) name.append(" ");
            }
//            System.out.println(name);
            int year = Integer.parseInt(strings[strings.length - 1]) - 1900;
            int month = Integer.parseInt(strings[strings.length - 2]) - 1;
            int date = Integer.parseInt(strings[strings.length - 3]);
            Date birthDay = new Date(year, month, date);

            PEOPLE.add(new Person(name.toString(), birthDay));
        }
        fileReader.close();

        for (Person person :PEOPLE) {
            System.out.println(person.getName() + " " + person.getBirthday().getDate() +
             " " + person.getBirthday().getMonth() +
            " " + person.getBirthday().getYear());
        }

    }
}
