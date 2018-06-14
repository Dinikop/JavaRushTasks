package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat dateFormatInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person;
        try {
            //=========================
            if (args[0].equals("-c")) {
                if (args[2].equals("м")) {
                    person = Person.createMale(args[1], dateFormatInput.parse(args[3]));
                }
                else person = Person.createFemale(args[1], dateFormatInput.parse(args[3]));
                allPeople.add(allPeople.size(), person);
                System.out.println(allPeople.size() - 1);
            }
            //=========================
            else if (args[0].equals("-u")) {
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(args[2]);
                person.setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
                person.setBirthDay(dateFormatInput.parse(args[4]));
            }
            //=========================
            else if (args[0].equals("-d")) {
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);
            }
            //=========================
            else {
                person = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(person);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        for (Person person1 :allPeople) {
//            System.out.println(person1);
//        }
    }
}
