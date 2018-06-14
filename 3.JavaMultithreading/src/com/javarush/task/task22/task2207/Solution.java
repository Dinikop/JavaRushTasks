package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();

        StringBuilder sb = new StringBuilder();
        int input;
        while ((input = fileReader.read()) != -1) {
            sb.append((char) input);
        }
        List<String> strings = new LinkedList<>(Arrays.asList(sb.toString().split("[ \n]")));

//        for (String s :strings) {
//            System.out.println(s);
//        }

        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            if (string.isEmpty()) continue;
            String reverseString = new StringBuilder(string).reverse().toString();
//            System.out.printf("string: %s, reverse: %s\n", string, reverseString);
            for (int j = i + 1; j < strings.size(); j++) {
                String string1 = strings.get(j);
                if (string1.equals(reverseString)) {
                    result.add(new Pair(string, reverseString));
                    strings.remove(i);
                    strings.remove(j - 1);
                    i--;
                    break;
                }
            }
        }

        for (Pair pair :result) {
            System.out.println(pair);
        }


    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
