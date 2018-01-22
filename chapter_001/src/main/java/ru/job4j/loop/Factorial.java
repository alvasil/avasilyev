package ru.job4j.loop;

/*
1. Необходимо создать класс Factorial;
2. В классе Factorial написать метод public int calc(int n) {};
3. В качестве аргумента в метод приходит положительное целое число n, сам метод должен возвращать рассчитанный факториал для этого числа;
 */

public class Factorial {
    public int calc(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
