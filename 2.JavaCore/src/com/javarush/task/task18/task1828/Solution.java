package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length != 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            ArrayList<String> list = new ArrayList<>();
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            int id = Integer.parseInt(args[1]);
            int currentId;
            String s = "";
            while ((s = fileReader.readLine()) != null) {
                currentId = getID(s);
                if (currentId == id && args[0].equals("-d")) continue;
                if (currentId == id && args[0].equals("-u")) {
                    String s1 = prepareForWrite(String.valueOf(id), 8) +
                            prepareForWrite(args[2], 30) +
                            prepareForWrite(args[3], 8) +
                            prepareForWrite(args[4], 4);
                    list.add(s1);
                    continue;
                }
                list.add(s);
            }
            fileReader.close();

            BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            for (String s1 :list) {
                fileWriter.write(s1);
                fileWriter.newLine();
            }
            fileWriter.flush();
            fileWriter.close();
        }
    }

    private static int getID(String s) {
        Pattern p = Pattern.compile("^\\d{1,8}");
        Matcher m = p.matcher(s);
        String s1 = "";
        while (m.find()) {
            s1 = s.substring(m.start(), m.end());
        }
        return Integer.parseInt(s1);
    }

    private static String prepareForWrite(String s, int i) {

        if (s.length() == i) return s;
        else if (s.length() < i) {
            StringBuilder s1 = new StringBuilder(s);
            for (int j = 0; j < i - s.length(); j++) {
                s1.append(" ");
            }
            return s1.toString();
        }
        else {
            return s.substring(0, i);
        }
    }
}
