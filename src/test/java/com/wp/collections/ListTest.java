package com.wp.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ListTest {
    private final List<String> elements;

    public ListTest(List<String> elements) {
        this.elements = elements;
    }

    @Test
    public void addShouldSaveOneElement() {
        addElementsToList(1);
        Assertions.assertEquals("sowa", elements.get(0));
    }

    @Test
    public void addShouldSaveManyElements() {
        addElementsToList(3);
        Assertions.assertEquals("sowa", elements.get(2));
        Assertions.assertEquals(3, elements.size());
    }

    @Test
    public void addShouldSaveVeryManyElements() {
        addElementsToList(12);
        Assertions.assertEquals("sowa", elements.get(11));
        Assertions.assertEquals(12, elements.size());
    }

    private void addElementsToList(int howManyElements) {
        for (int i = 0; i < howManyElements - 1; i++) {
            elements.add("kot");
        }
        elements.add("sowa");
    }
}
