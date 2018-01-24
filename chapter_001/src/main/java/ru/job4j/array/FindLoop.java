package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int el) {
        // если элемента нет в массиве, то возвращаем -1.
        int rsl = -1;
        for (int index = 0; index <= data.length; index++) {
            data[index] = index;
            if (data[index] == el) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
