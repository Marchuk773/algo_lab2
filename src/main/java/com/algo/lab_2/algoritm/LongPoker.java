package com.algo.lab_2.algoritm;

import java.io.IOException;
import com.algo.lab_2.utils.MyArrayList;
import com.algo.lab_2.utils.MyFileReader;
import com.algo.lab_2.utils.QuickSort;

public class LongPoker {

    private MyArrayList<Integer> array;

    public LongPoker(String filename) {
        try {
            String[] values = MyFileReader.readInput(filename);
            array = new MyArrayList<>(values.length / 2);
            for (String number : values) {
                array.push(Integer.parseInt(number));
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        QuickSort.sort(array);
    }

    public int solve() {

        int index = -1;

        int jokersCount = 0;

        int availableJokers = 0;

        int currentStreak = 0;

        int longestStreak = 0;

        int revizitedIndex = -1;

        while (array.itemAt(++index) == 0) {
            jokersCount++;
        }
        availableJokers = jokersCount;

        while (index < array.getLength() - 1) {
            if (array.itemAt(index + 1) - array.itemAt(index) == 1) {
                currentStreak++;
                index++;
            }

            else if (array.itemAt(index + 1) - array.itemAt(index) == 0) {
                index++;
            }

            else {

                int neededJokers = array.itemAt(index + 1) - array.itemAt(index) - 1;

                if (array.itemAt(index) + availableJokers >= array.itemAt(index + 1) - 1) {
                    availableJokers -= neededJokers;
                    currentStreak += neededJokers + 1;
                    index++;
                    if (revizitedIndex == -1) {
                        revizitedIndex = index;
                    }
                }

                else {
                    currentStreak += availableJokers;
                    if (longestStreak < currentStreak) {
                        longestStreak = currentStreak;
                    }
                    availableJokers = jokersCount;
                    currentStreak = 0;
                    if (neededJokers > jokersCount) {
                        revizitedIndex = -1;
                        index++;
                    } else if (revizitedIndex == -1) {
                        index++;
                    } else {
                        index = revizitedIndex;
                        revizitedIndex = -1;
                    }
                }
            }
        }

        currentStreak += availableJokers;
        if (longestStreak < currentStreak) {
            longestStreak = currentStreak;
        }

        return longestStreak + 1;

    }

}
