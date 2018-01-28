package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenTwoSameWordsThenDeleteOne() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] input = array.remove(new String[] {"hi", "hi", "world", "world"});
        String[] expect = {"hi", "world"};
        assertThat(input, arrayContainingInAnyOrder(expect));
    }
}
