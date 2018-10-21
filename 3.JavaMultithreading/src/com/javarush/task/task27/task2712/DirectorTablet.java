package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Locale;
import java.util.stream.Collectors;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        double totalProfit = 0;
        StatisticManager.getInstance().getAdvertisementProfit()
                .forEach((k, v) ->
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH,"%s - %.2f", k, v / 100.00)));

        long sum = StatisticManager.getInstance().getAdvertisementProfit().values().stream().collect(Collectors.summarizingLong(Long::longValue)).getSum();
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", sum / 100.00));
    }

    public void printCookWorkloading() {
        StatisticManager.getInstance().getCookWorkloading()
                .forEach((k,v) -> {
                    System.out.println(k);
                    v.forEach((k1, v1) -> System.out.println(k1 + " - " + v1 + " min"));
                });
    }

    public void printActiveVideoSet() {

    }

    public void printArchivedVideoSet() {

    }


}
