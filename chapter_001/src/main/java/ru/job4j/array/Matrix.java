package ru.job4j.array;

public class Matrix {
    int[][] multiple(int size) {
        int[][] data = new int[size][size];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                data[i][j] = i * j;
            }
        }
        return data;
    }
}
