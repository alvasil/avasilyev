package ru.job4j.loop;

/*
1. Необходимо создать класс Factorial;
2. В классе Factorial написать метод public int calc(int n) {};
3. В качестве аргумента в метод приходит положительное целое число n, сам метод должен возвращать рассчитанный факториал для этого числа;
 */

public class Factorial {
    int fact = 1;

    public int calc(int n) {
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        if (n == 0) {
            fact = 1;
        }
        return fact;
    }
}
