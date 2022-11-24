package com.wp.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListTest1 {
    private final List<String> elements = new MyLinkedList<>();

    private void addManyTheSameElementsToList(int howManyElements) {
        for (int i = 0; i < howManyElements - 1; i++) {
            elements.add(0 + "");
        }
        elements.add(1 + "");
    }

    private void addDifferentElementsToList(int howManyElements) {
        for (int i = 0; i < howManyElements; i++) {
            elements.add(i + "");
        }
    }

    @Test
    public void setShouldSetObjectInSpecificIndex() {

        addDifferentElementsToList(10);

        Assertions.assertEquals("3", elements.set(3, "50"));
        Assertions.assertEquals("50", elements.get(3));
        Assertions.assertEquals("2", elements.get(2));
        Assertions.assertEquals("4", elements.get(4));
    }
}