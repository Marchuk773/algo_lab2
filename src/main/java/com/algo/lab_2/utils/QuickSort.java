package com.algo.lab_2.utils;

public class QuickSort {
    public static void sort(MyArrayList<Integer> givenArray) {
        givenArray.shuffle();
        int pivot = partition(givenArray, 0, givenArray.getLength() - 1);
        sort(givenArray, 0, pivot - 1);
        sort(givenArray, pivot + 1, givenArray.getLength() - 1);
    }

    private static void sort(MyArrayList<Integer> givenArray, int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            return;
        }
        int pivot = partition(givenArray, lowerBound, upperBound);
        sort(givenArray, lowerBound, pivot - 1);
        sort(givenArray, pivot + 1, upperBound);
    }

    private static int partition(MyArrayList<Integer> givenArray, int startingPosition,
            int endingPosition) {
        int lowerBound = startingPosition, upperBound = endingPosition + 1;
        while (true) {

            while (givenArray.itemAt(++lowerBound) <= givenArray.itemAt(startingPosition)) {
                if (lowerBound == endingPosition) {
                    break;
                }
            }

            while (givenArray.itemAt(--upperBound) >= givenArray.itemAt(startingPosition)) {
                if (upperBound == startingPosition) {
                    break;
                }
            }

            if (lowerBound >= upperBound) {
                break;
            }
            givenArray.swap(lowerBound, upperBound);
        }
        givenArray.swap(startingPosition, upperBound);
        return upperBound;
    }

}
