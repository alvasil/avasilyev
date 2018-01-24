package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    @Test
    public void whenIndexFiveElFive() {
        FindLoop findloop = new FindLoop();
        int result = findloop.indexOf(new int[10], 5);
        assertThat(result, is(5));
    }
}
