package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public void register(EventDataRow data){
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

            for (EventType eventType :EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }

        }

        private void put(EventDataRow data) {

            List<EventDataRow> addList = storage.get(data.getType());
            addList.add(data);
            storage.put(data.getType(), addList);
        }
    }
}
