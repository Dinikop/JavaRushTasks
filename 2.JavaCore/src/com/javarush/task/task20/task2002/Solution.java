package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            //--------------------------------

            User user = new User();
            user.setFirstName("Rubi");
            user.setLastName("Rail");
//            user.setBirthDate(new Date(1508944516168L));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);

            User user1 = new User();
            user1.setFirstName("Vasa1");
            user1.setLastName("Peta1");
            user1.setBirthDate(new Date(1508944516163L));
            user1.setMale(true);
//            user1.setCountry(User.Country.RUSSIA);

            User user3 = new User();
            user3.setFirstName("Solo");
            user3.setLastName("Han");
            user3.setBirthDate(new Date(1508944516169L));
            user3.setMale(true);
            user3.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user);
            javaRush.users.add(user1);
            javaRush.users.add(user3);
            //--------------------------------
            javaRush.save(outputStream);
            outputStream.flush();


            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны


            //--------------------------------
            System.out.println(javaRush.equals(loadedObject));
            //--------------------------------

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);

            for (User user :users) {

                if (user.getFirstName().isEmpty()) printWriter.print("null ");
                else printWriter.print(user.getFirstName() + " ");

                if (user.getLastName().isEmpty()) printWriter.print("null ");
                else printWriter.print(user.getLastName() + " ");

                if (user.getBirthDate() == null) printWriter.print("null ");
                else printWriter.print(user.getBirthDate().getTime() + " ");

                if (user.isMale()) printWriter.print(true + " ");
                else printWriter.print(false + " ");

                if (user.getCountry() == null) printWriter.print("null");
                else printWriter.print(user.getCountry());

                printWriter.println();
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String input;
            while ((input = reader.readLine()) != null) {
                String[] s = input.split(" ");
                User user = new User();
                if (!s[0].equals("null")) user.setFirstName(s[0]);
                if (!s[1].equals("null")) user.setLastName(s[1]);
                if (!s[2].equals("null")) user.setBirthDate(new Date(Long.parseLong(s[2])));

                if (s[3].equals("true")) user.setMale(true);
                else user.setMale(false);

                if (!s[4].equals("null")) user.setCountry(User.Country.valueOf(s[4]));
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
