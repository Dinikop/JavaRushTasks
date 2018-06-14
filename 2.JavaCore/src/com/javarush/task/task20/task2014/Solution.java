package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\DEV\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\tmp.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\DEV\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\tmp.txt");


            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            Solution solution = new Solution(3);
            oos.writeObject(solution);
            Solution loadedObject = new Solution(5);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            loadedObject = (Solution) ois.readObject();
            System.out.println(solution);
            System.out.println(loadedObject);
            System.out.println(solution.toString().equals(loadedObject.toString()));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        System.out.println(new Solution(4));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }


}
