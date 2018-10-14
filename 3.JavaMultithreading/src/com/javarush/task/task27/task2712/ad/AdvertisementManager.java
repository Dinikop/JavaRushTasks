package com.javarush.task.task27.task2712.ad;

import java.util.*;
import java.util.stream.Collectors;

public class AdvertisementManager {

    private static List<List<Advertisement>> allLists = new ArrayList<>();

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty()) throw new NoVideoAvailableException();

        List<Advertisement> validVideos = storage.list()
                .stream()
                .filter(x -> x.getHits() > 0 && x.getDuration() <= timeSeconds)
                .collect(Collectors.toList());

        if (validVideos.isEmpty()) return;

        for (int i = 0; i <= validVideos.size(); i++) {
            makeCombination(validVideos.toArray(new Advertisement[0]), validVideos.size(), i);
        }

//        //test-------------------------------------------------
//        System.out.println("before sorting");
//        allLists.forEach(x -> {
//            x.forEach(y -> System.out.print(y.getName() + " | "));
//            System.out.print(" durations " + x.stream().mapToInt(Advertisement::getDuration).sum() + "\n");
//        });
//        //test end --------------------------------------------

        allLists = allLists
                .stream()
                .filter(x -> x.stream().mapToInt(Advertisement::getDuration).sum() <= timeSeconds)
                .sorted(Comparator.comparing((List<Advertisement> x) -> x.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum()).reversed()
//                        .thenComparing(x -> x.stream().mapToInt(Advertisement::getDuration).sum())
                        .thenComparing(List::size)
                )
                .collect(Collectors.toList());

//        //test-------------------------------------------------
//        System.out.println("\nafter sorting");
//        allLists.forEach(x -> {
//            x.forEach(y -> System.out.print(y.getName() + " | "));
//            System.out.print(" durations " + x.stream().mapToInt(Advertisement::getDuration).sum() +
//                    " " + "amount " + x.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum() + "\n");
//        });
//        //test end --------------------------------------------

        List<Advertisement> listToShow = allLists.get(0);

        Collections.sort(listToShow,
                Comparator.comparing(Advertisement::getAmountPerOneDisplaying).reversed()
                .thenComparing(x -> x.getAmountPerOneDisplaying() * 1000 / x.getDuration()));

        listToShow.forEach(x -> {
            System.out.println(x.getName()
                    + " is displaying... "
                    + x.getAmountPerOneDisplaying()
                    + ", "
                    + x.getAmountPerOneDisplaying() * 1000 / x.getDuration());
            x.revalidate();
        });


    }
//
//    public static void main(String[] args) {
//        AdvertisementManager advertisementManager = new AdvertisementManager(600);
//        advertisementManager.processVideos();
//    }

    /* arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */

    private static void combinationUtil(Advertisement arr[], Advertisement data[], int start,
                                        int end, int index, int r) {
        // Current combination is ready to be printed, print it
        if (index == r) {
            List<Advertisement> tempList = new ArrayList<>(Arrays.asList(data).subList(0, r));
            allLists.add(tempList);
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    private static void makeCombination(Advertisement arr[], int n, int r) {
        // A temporary array to store all combination one by one
        Advertisement data[] = new Advertisement[r];
        combinationUtil(arr, data, 0, n - 1, 0, r);
    }


}
