package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.stream.Collectors;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        double totalProfit = 0;
        StatisticManager.getInstance().getAdvertisementProfit().forEach((k, v) -> {
            System.out.printf("%s - %d\n", k, v / 100);

        });
        long sum = StatisticManager.getInstance().getAdvertisementProfit().values().stream().collect(Collectors.summarizingLong(Long::longValue)).getSum();
        System.out.printf("Total - %d", sum / 100);
    }

    public void printCookWorkloading() {

    }

    public void printActiveVideoSet() {

    }

    public void printArchivedVideoSet() {

    }


}
