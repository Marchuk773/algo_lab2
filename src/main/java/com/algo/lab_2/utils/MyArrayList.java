package com.algo.lab_2.utils;

import java.util.Iterator;
import java.util.Random;

public class MyArrayList<T> implements Iterable<T> {

    private T[] array;

    private int currentLength = 0;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (T[]) new Object[2];
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void push(T item) {
        if (currentLength == array.length) {
            resize(array.length);
        }
        array[currentLength++] = item;
    }

    public T itemAt(int index) {
        return array[index];
    }

    public void placeItem(int index, T item) {
        array[index] = item;
    }

    public int getLength() {
        return currentLength;
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < currentLength; i++) {
            int randomIndexToSwap = random.nextInt(currentLength);
            swap(i, randomIndexToSwap);
        }
    }

    public void swap(int firstIndex, int secondIndex) {
        T temporary = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temporary;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] auxArray = (T[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            auxArray[i] = array[i];
        }
        array = auxArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayIterator<T>();
    }

    @SuppressWarnings("hiding")
    private class MyArrayIterator<T> implements Iterator<T> {

        private int lenght = 0;

        @Override
        public boolean hasNext() {
            return lenght < currentLength;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            return (T) array[lenght++];
        }

    }

    @Override
    public String toString() {
        String printedList = "";
        for (T number : this) {
            printedList += number + " ";
        }
        return "[" + printedList.substring(0, printedList.length() - 1) + "]";
    }

}
