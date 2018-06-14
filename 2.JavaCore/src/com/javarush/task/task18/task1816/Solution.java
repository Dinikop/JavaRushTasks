package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

        String s;
        int count = 0;

        Pattern pattern = Pattern.compile("[A-Za-z]");
        Matcher matcher;

        while ((s = fileReader.readLine()) != null) {
            matcher = pattern.matcher(s);
            while (matcher.find()) ++count;
        }
        System.out.println(count);
        fileReader.close();
    }
}
