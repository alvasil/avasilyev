package ru.job4j.loop;

/*1. Необходимо создать класс Counter;
2. В классе Counter написать метод public int add(int start, int finish) {};
3. Метод должен вычислять сумму четныx чисел в диапазоне от start до finish;
  */

public class Counter {
    public int add(int start, int finish) {
        int summ = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                summ = summ + i;
            }
        }
        return summ;
    }
}
