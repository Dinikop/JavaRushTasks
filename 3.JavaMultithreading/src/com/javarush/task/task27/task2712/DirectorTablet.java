package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        double totalProfit = 0;
        StatisticManager.getInstance().getAdvertisementProfit()
                .forEach((k, v) ->
            System.out.printf("%s - %.2f\n", k, (double)v / 100));

        long sum = StatisticManager.getInstance().getAdvertisementProfit().values().stream().collect(Collectors.summarizingLong(Long::longValue)).getSum();
        System.out.printf("Total - %.2f", (double)sum / 100);
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


    public static void main(String[] args) {

        //=====================printAdvertisementProfitTest================================
        Object someContent = new Object();

        List<Advertisement> optimalVideoSet = new ArrayList<>();
        optimalVideoSet.add(new Advertisement(someContent, "First Video", 500, 10, 3 * 60));
        optimalVideoSet.add(new Advertisement(someContent, "First Video", 50, 10, 3 * 60));
        optimalVideoSet.add(new Advertisement(someContent, "First Video", 5, 1, 3 * 60));

        GregorianCalendar date1 = new GregorianCalendar(2013, 4, 13);
        GregorianCalendar date2 = new GregorianCalendar(2013, 4, 14);
        GregorianCalendar date3 = new GregorianCalendar(2013, 4, 15);
        GregorianCalendar date4 = new GregorianCalendar(2013, 4, 15);

        VideoSelectedEventDataRow videoEvent1 = new VideoSelectedEventDataRow(optimalVideoSet, 1000, 90);
        videoEvent1.setCurrentDate(date1.getTime());

        VideoSelectedEventDataRow videoEvent2 = new VideoSelectedEventDataRow(optimalVideoSet, 200, 35);
        videoEvent2.setCurrentDate(date2.getTime());

        VideoSelectedEventDataRow videoEvent3 = new VideoSelectedEventDataRow(optimalVideoSet, 900, 9);
        videoEvent3.setCurrentDate(date3.getTime());

        VideoSelectedEventDataRow videoEvent4 = new VideoSelectedEventDataRow(optimalVideoSet, 400, 80);
        videoEvent4.setCurrentDate(date4.getTime());

        StatisticManager.getInstance().register(videoEvent1);
        StatisticManager.getInstance().register(videoEvent2);
        StatisticManager.getInstance().register(videoEvent3);
        StatisticManager.getInstance().register(videoEvent4);

        //===============printCookWorkloading========================

        List<Dish> dishes = new ArrayList<>();

        CookedOrderEventDataRow cookedOrderEvent1 = new CookedOrderEventDataRow("1", "Ivanov", 500, dishes);
        cookedOrderEvent1.setCurrentDate(date1.getTime());
        CookedOrderEventDataRow cookedOrderEvent2 = new CookedOrderEventDataRow("1", "Petrov", 400, dishes);
        cookedOrderEvent2.setCurrentDate(date1.getTime());

        CookedOrderEventDataRow cookedOrderEvent3 = new CookedOrderEventDataRow("1", "Ivanov", 600, dishes);
        cookedOrderEvent3.setCurrentDate(date2.getTime());
        CookedOrderEventDataRow cookedOrderEvent4 = new CookedOrderEventDataRow("1", "Petrov", 700, dishes);
        cookedOrderEvent4.setCurrentDate(date2.getTime());
        CookedOrderEventDataRow cookedOrderEvent5 = new CookedOrderEventDataRow("1", "Ivanov", 550, dishes);
        cookedOrderEvent5.setCurrentDate(date2.getTime());
        CookedOrderEventDataRow cookedOrderEvent6 = new CookedOrderEventDataRow("1", "Petrov", 770, dishes);
        cookedOrderEvent6.setCurrentDate(date2.getTime());

        CookedOrderEventDataRow cookedOrderEvent7 = new CookedOrderEventDataRow("1", "Ivanov", 880, dishes);
        cookedOrderEvent7.setCurrentDate(date3.getTime());

        StatisticManager.getInstance().register(cookedOrderEvent1);
        StatisticManager.getInstance().register(cookedOrderEvent2);
        StatisticManager.getInstance().register(cookedOrderEvent3);
        StatisticManager.getInstance().register(cookedOrderEvent4);
        StatisticManager.getInstance().register(cookedOrderEvent5);
        StatisticManager.getInstance().register(cookedOrderEvent6);
        StatisticManager.getInstance().register(cookedOrderEvent7);

        DirectorTablet directorTablet = new DirectorTablet();

        System.out.println("Test advertisement profit");
        directorTablet.printAdvertisementProfit();

        System.out.println("\nTest cookworkloading");
        directorTablet.printCookWorkloading();
    }
}
