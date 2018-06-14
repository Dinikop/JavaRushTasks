package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args.length != 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            String s = "";
            int currentId = 0, id = 0;
            while ((s = fileReader.readLine()) != null) {
                currentId = getID(s);
                if (currentId > id) id = currentId;
            }
            id++;

            fileReader.close();

            StringBuilder out = new StringBuilder();
            out.append(prepareForWrite(String.valueOf(id), 8));
            out.append(prepareForWrite(args[1], 30));
            out.append(prepareForWrite(args[2], 8));
            out.append(prepareForWrite(args[3], 4));

            BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
            fileWriter.newLine();
            fileWriter.write(out.toString());
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
