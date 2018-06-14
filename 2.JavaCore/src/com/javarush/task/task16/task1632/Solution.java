package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new InfitityThread());
        threads.add(new InterruptThread());
        threads.add(new HoorayThread());
        threads.add(new MessageThread());
        threads.add(new InputThread());
    }


    public static void main(String[] args) {
    }

    public static class InfitityThread extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class InterruptThread extends Thread {
        @Override
        public void run() {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class HoorayThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    sleep(500);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public static class MessageThread extends Thread implements Message {
        @Override
        public void showWarning() {
            this.interrupt();
        }

        @Override
        public void run() {
            while (!isInterrupted()) {

            }
        }
    }

    public static class InputThread extends Thread {
        private int sum;

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s ="";
            while (true) {
                try {
                    s = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s.equals("N"))  {
                    System.out.println(sum);
                    break;
                }
                sum += Integer.parseInt(s);
            }
        }
    }
}