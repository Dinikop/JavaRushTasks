package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move() {
        for (Horse horse :horses) {
            horse.move();
        }

    }

    public void print() {
        for (Horse horse :horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                move();
                print();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Horse getWinner() {
        double max = 0;
        for (Horse horse :horses) {
            if (horse.getDistance() > max) max = horse.getDistance();
        }
        int indexOfWinner = 0;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getDistance() == max) indexOfWinner = i;
        }
        return horses.get(indexOfWinner);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    static Hippodrome game;

    public static void main(String[] args) {
        Hippodrome.game = new Hippodrome(new ArrayList<>());
        Hippodrome.game.horses.add(new Horse("Alladin", 3, 0));
        Hippodrome.game.horses.add(new Horse("Viksent", 3, 0));
        Hippodrome.game.horses.add(new Horse("Alloha", 3, 0));
        Hippodrome.game.run();
        Hippodrome.game.printWinner();
    }
}
