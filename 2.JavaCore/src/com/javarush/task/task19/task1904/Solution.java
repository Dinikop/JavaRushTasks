package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(new File("D:\\DEV\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1904\\dataBase.txt"));
//        PersonScannerAdapter psa = new PersonScannerAdapter(scanner);
//        psa.read();
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person person = null;
            if (fileScanner.hasNext()) {
                String s = fileScanner.nextLine();
                String[] pS = s.split(" ");
                SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
                Date birthDay = null;
                try {
                    birthDay = dateFormat.parse(pS[3] + pS[4] + pS[5]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                person = new Person(pS[1], pS[2], pS[0], birthDay);
            }

            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
