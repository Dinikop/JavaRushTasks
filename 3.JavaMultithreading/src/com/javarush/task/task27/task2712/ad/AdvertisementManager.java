package com.javarush.task.task27.task2712.ad;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty()) throw new NoVideoAvailableException();

//        List<Advertisement> sortedList = storage.list()
//                .stream()
//                .sorted(Comparator.comparing(Advertisement::getAmountPerOneDisplaying)
//                        .thenComparing(Advertisement::getDuration).reversed())
//                .collect(Collectors.toList());

        long[][] cost = new long[storage.list().size()][timeSeconds];

        for (int k = 1; k < storage.list().size(); k++) {  //предметы
            for (int s = 1; s < timeSeconds; s++) {        //длительность
                if (s >= storage.list().get(k).getDuration()) {
                    cost[k][s] = Long.max(cost[k-1][s], cost[k-1][s-storage.list().get(k).getDuration()] + storage.list().get(k).getAmountPerOneDisplaying());
                }
                else cost[k][s] = cost[k-1][s];
            }
        }

        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[i].length; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }

        List<Advertisement> list = new ArrayList<>();
        int k = storage.list().size() - 1;
        int s = timeSeconds - 1;

        while (true) {
            if (cost[k][s] == 0) break;
            if (cost[k-1][s] == cost[k][s]) {
                k--;
            }
            else {
                list.add(storage.list().get(k));
                k--;
                s -= storage.list().get(k).getDuration();
            }
        }

        list.forEach((x) -> System.out.println(x + " " + x.getAmountPerOneDisplaying() + " " + x.getDuration()) );

    }

    public static void main(String[] args) {
        AdvertisementManager advertisementManager = new AdvertisementManager(2000);
        advertisementManager.processVideos();
    }


}
