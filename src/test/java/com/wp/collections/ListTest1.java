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
    public void addShouldAddElementOnSpecificPosition() {

        addDifferentElementsToList(10);

        elements.add(5, "100");
        //
        Object[] tab1 = elements.toArray(); // CHECK : 20.11.2022 dlaczego tab1 nie może być typu String?
        //

        Assertions.assertEquals("4", elements.get(4));
        Assertions.assertEquals("100", elements.get(5));
        Assertions.assertEquals("5", elements.get(6));
        Assertions.assertEquals("0", elements.get(0));
        Assertions.assertEquals("9", elements.get(elements.size() - 1));

        elements.add(9,"55");

        Assertions.assertEquals("55", elements.get(elements.size() - 1));

    }

    @Test
    public void removeShouldDeleteElementOnSpecificIndex() {

        addDifferentElementsToList(20);

        Assertions.assertEquals("19", elements.remove(19));
        Assertions.assertEquals("5", elements.remove(5));
        Assertions.assertEquals("0", elements.remove(0));
        Assertions.assertEquals(17, elements.size());
        Assertions.assertEquals("18", elements.get(elements.size() - 1));
        Assertions.assertEquals("7", elements.get(5));
        Assertions.assertEquals("1", elements.get(0));
    }


}