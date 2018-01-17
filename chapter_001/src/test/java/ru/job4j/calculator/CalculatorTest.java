package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double resultAdd = calc.getResultAdd();
        double expectedAdd = 2D;
        assertThat(resultAdd, is(expectedAdd));
    }
    @Test
    public void whenSubtractTwoMinusOneThenOne() {
        Calculator calc = new Calculator();
        calc.subtract(2D, 1D);
        double resultSub = calc.getResultSub();
        double expectedSub = 1D;
        assertThat(resultSub, is(expectedSub));
    }
    @Test
    public void whenDivFourDevideTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.div(4D, 2D);
        double resultDiv = calc.getResultDiv();
        double expectedDiv = 2D;
        assertThat(resultDiv, is(expectedDiv));
    }
    @Test
    public void whenMultipleTwoMultiplyTwoThenFour() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 2D);
        double resultMult = calc.getResultMult();
        double expectedMult = 4D;
        assertThat(resultMult, is(expectedMult));
    }

}