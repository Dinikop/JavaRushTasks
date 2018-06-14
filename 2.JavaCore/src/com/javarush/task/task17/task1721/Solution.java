package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            BufferedReader fileReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
            BufferedReader fileReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));

            String line;
            while (true) {
                line = fileReader1.readLine();
                if (line == null) break;
                allLines.add(line);
            }

            while (true) {
                line = fileReader2.readLine();
                if (line == null) break;
                forRemoveLines.add(line);
            }

            Solution sol = new Solution();
            sol.joinData();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
