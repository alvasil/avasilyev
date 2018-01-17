package ru.job4j.calculator;

public class Calculator {
    private double resultAdd, resultSub, resultDiv, resultMult;

    public void add(double first, double second) {
        this.resultAdd = first + second;
    }

    public void subtract(double first, double second) {
        this.resultSub = first - second;
    }

    public void div(double first, double second) {
        this.resultDiv = first / second;
    }

    public void multiple(double first, double second) {
        this.resultMult = first * second;
    }

    public double getResultAdd() {
        return this.resultAdd;
    }

    public double getResultSub() {
        return this.resultSub;
    }

    public double getResultDiv() {
        return this.resultDiv;
    }

    public double getResultMult() {
        return this.resultMult;
    }
}