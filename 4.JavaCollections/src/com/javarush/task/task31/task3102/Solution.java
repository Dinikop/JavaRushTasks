package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        Queue<File> queue = new LinkedList<>(Arrays.asList(new File(root).listFiles()));

        while (!queue.isEmpty()) {
            File element = queue.poll();
            if (element.isDirectory()) queue.addAll(Arrays.asList(element.listFiles()));
            else result.add(element.getAbsolutePath());
        }

        return result;

    }

    public static void main(String[] args) {
        try {
            ArrayList<String> list = new ArrayList<>(getFileTree("D:\\DokuWikiStick"));
            for (String s :list) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
