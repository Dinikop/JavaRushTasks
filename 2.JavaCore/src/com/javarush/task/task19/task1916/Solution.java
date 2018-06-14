package com.javarush.task.task19.task1916;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        ArrayList<String> file1 = new ArrayList<>();
        ArrayList<String> file2 = new ArrayList<>();

        String input = "";
        while ((input = fileReader1.readLine()) != null) {
            file1.add(input);
        }
        fileReader1.close();


        while ((input = fileReader2.readLine()) != null) {
            file2.add(input);
        }
        fileReader2.close();


//        String[] file1 = new String[f1.size()];
//        f1.toArray(file1);
//
//        String[] file2 = new String[f2.size()];
//        f2.toArray(file2);

        for (int i = 0; i < file1.size(); i++) {

            if (file2.size() == 1) {
                if (file1.get(i).equals(file2.get(0))) {
                    lines.add(new LineItem(Type.SAME, file1.get(i)));
                }
                else {
                    lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                    lines.add(new LineItem(Type.ADDED, file2.get(0)));
                    file2.remove(0);
                }
            }

            if (file2.size() == 0) {
                lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                break;
            }



            if (file1.get(i).equals(file2.get(0))) {
                lines.add(new LineItem(Type.SAME, file1.get(i)));
                file2.remove(0);
            } else if (file1.get(i).equals(file2.get(1))) {
                lines.add(new LineItem(Type.ADDED, file2.get(0)));
                file2.remove(0);
                i--;
            } else lines.add(new LineItem(Type.REMOVED, file1.get(i)));

        }

        if (file2.size() != 0) {
            for (String s :file2) {
                lines.add(new LineItem(Type.ADDED, s));
            }

        }

//        for (LineItem lineItem :lines) {
//            System.out.println(lineItem);
//        }


    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

//        @Override
//        public String toString() {
//            return this.type.toString() + " " + this.line;
//        }
    }
}
