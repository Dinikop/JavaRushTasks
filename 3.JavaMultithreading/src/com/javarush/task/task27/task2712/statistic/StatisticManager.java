package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    private Set<Cook> cooks = new HashSet<>();

    public void register(Cook cook) {
        cooks.add(cook);
    }

    private class StatisticStorage {

        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();

            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }

        }

        private void put(EventDataRow data) {

            List<EventDataRow> addList = storage.get(data.getType());
            addList.add(data);
            storage.put(data.getType(), addList);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return Collections.unmodifiableMap(storage);
        }
    }

    public Map<String, Long> getAdvertisementProfit() {
        Map<String, Long> result = new TreeMap<>(Collections.reverseOrder());

        List<EventDataRow> videoSelectedEvents = statisticStorage.storage.get(EventType.SELECTED_VIDEOS);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        for (EventDataRow eventDataRow : videoSelectedEvents) {
            String date = simpleDateFormat.format(eventDataRow.getDate());
            Long amount = ((VideoSelectedEventDataRow) eventDataRow).getAmount();
            result.merge(date, amount, (k, v) -> v + k);
        }
        return result;
    }

    public Map<String, Map<String, Integer>> getCookWorkloading() {

        Map<String, Map<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());

        List<EventDataRow> cookedOrders = statisticStorage.storage.get(EventType.COOKED_ORDER);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        for (EventDataRow eventDataRow : cookedOrders) {
            String date = simpleDateFormat.format(eventDataRow.getDate());
            String cookName = ((CookedOrderEventDataRow) eventDataRow).getCookName();
            int time = ((CookedOrderEventDataRow) eventDataRow).getTime();


            if (!result.containsKey(date)) {
                Map<String, Integer> cookWorkTime = new TreeMap<>();
                cookWorkTime.put(cookName, time);
                result.put(date, cookWorkTime);
            } else {
                Map<String, Integer> cookWorkTime = result.get(date);
                if (!cookWorkTime.containsKey(cookName)) {
                    cookWorkTime.put(cookName, time);
                } else {
                    cookWorkTime.put(cookName, cookWorkTime.get(cookName) + time);
                }
            }


        }
        return result;

    }
}
