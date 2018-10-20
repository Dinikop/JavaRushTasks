package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticManagerTest {



    @Test
    public static void main() {

        Object someContent = new Object();

        List<Advertisement> optimalVideoSet = new ArrayList<>();
        optimalVideoSet.add(new Advertisement(someContent, "First Video", 500, 10, 3 * 60));
        optimalVideoSet.add(new Advertisement(someContent, "First Video", 50, 10, 3 * 60));
        optimalVideoSet.add(new Advertisement(someContent, "First Video", 5, 1, 3 * 60));

        GregorianCalendar date1 = new GregorianCalendar(2013, 4, 13);
        GregorianCalendar date2 = new GregorianCalendar(2013, 4, 14);
        GregorianCalendar date3 = new GregorianCalendar(2013, 4, 15);

        VideoSelectedEventDataRow videoEvent1 = new VideoSelectedEventDataRow(optimalVideoSet, 500, 90);
        videoEvent1.setCurrentDate(date1.getTime());

        VideoSelectedEventDataRow videoEvent2 = new VideoSelectedEventDataRow(optimalVideoSet, 200, 35);
        videoEvent2.setCurrentDate(date2.getTime());

        VideoSelectedEventDataRow videoEvent3 = new VideoSelectedEventDataRow(optimalVideoSet, 5, 9);
        videoEvent3.setCurrentDate(date3.getTime());

        StatisticManager.getInstance().register(videoEvent1);
        StatisticManager.getInstance().register(videoEvent2);
        StatisticManager.getInstance().register(videoEvent3);



    }
}