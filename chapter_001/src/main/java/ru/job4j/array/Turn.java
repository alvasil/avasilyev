package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        for (int index = 0; index < array.length; index++) {
            array[index] = array.length - index;
        }
        return array;
    }
}
