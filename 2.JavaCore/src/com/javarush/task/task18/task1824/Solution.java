package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<FileInputStream> streams = new ArrayList<>();
        String fileName = "";
        try {
            while (true) {
                fileName = reader.readLine();
                streams.add(new FileInputStream(fileName));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(fileName);
            for (FileInputStream fileInputStream :streams) {
                try {
                    fileInputStream.close();
                    //System.out.println("closed");
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
