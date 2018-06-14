package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        ArrayList<Thread> threads = new ArrayList<>();
        while (true) {
            fileName = reader.readLine();
            if (fileName.equals("exit")) break;
            threads.add(new ReadThread(fileName));
        }

        for (Thread thread :threads) {
            thread.start();
        }

        for (Thread thread :threads) {
            thread.join();
        }

        //System.out.println(resultMap);


//        String fileName = reader.readLine();
//        ReadThread readThread = new ReadThread(fileName);
//        readThread.join();
//        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            super(fileName);
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                int data;
                HashMap<Integer, Integer> map = new HashMap<>();
                while (fileInputStream.available() > 0) {
                    data = fileInputStream.read();
                    if (map.containsKey(data)) {
                        map.replace(data, map.get(data) + 1);
                    } else map.put(data, 1);
                }
//                System.out.println(map);
                int maxValue = Collections.max(map.values());
                for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
                    if (entry.getValue() == maxValue) {
                        resultMap.put(getName(), entry.getKey());
                    }
                }
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println();
            }
        }
    }
}
