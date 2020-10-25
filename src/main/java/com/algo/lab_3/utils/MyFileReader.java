package com.algo.lab_3.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
    public static String[] readInput(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.readLine().split("\\s");
        }
    }
}
