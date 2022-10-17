package com.wp.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ListTest {
    private final List<String> elements;

    public ListTest(List<String> elements) {
        this.elements = elements;
    }

    private void addManyTheSameElementsToList(int howManyElements) {
        for (int i = 0; i < howManyElements - 1; i++) {
            elements.add(0 + "");
        }
        elements.add(1 + "");
    }

    private void addDifferentsElementsToList(int howManyElements) {
        for (int i = 0; i < howManyElements; i++) {
            elements.add(i + "");
        }
    }

    @Test
    public void addShouldSaveOneElement() {
        addManyTheSameElementsToList(1);
        Assertions.assertEquals("1", elements.get(0));
    }

    @Test
    public void addShouldSaveManyElements() {
        addManyTheSameElementsToList(3);
        Assertions.assertEquals("1", elements.get(2));
        Assertions.assertEquals(3, elements.size());
    }

    @Test
    public void addShouldSaveVeryManyElements() {
        addManyTheSameElementsToList(12);
        Assertions.assertEquals("0", elements.get(10));
        Assertions.assertEquals("1", elements.get(11));
        Assertions.assertEquals(12, elements.size());
    }

    @Test
    public void listShouldBeEmpty() {
        Assertions.assertTrue(elements.isEmpty());
    }// CHECK: 15.10.2022

    @Test
    public void removeShouldDeleteObject() {// CHECK: 15.10.2022
        addManyTheSameElementsToList(10);
        Assertions.assertEquals(10, elements.size());
        elements.remove("1");
        Assertions.assertEquals("0", elements.get(elements.size() - 1));
        Assertions.assertEquals(9, elements.size());
    }

    @Test
    public void clearShouldRemoveEverythingObjects() {// CHECK: 15.10.2022
        addManyTheSameElementsToList(30);
        Assertions.assertFalse(elements.isEmpty());
        elements.clear();
        Assertions.assertTrue(elements.isEmpty());// CHECK: 17.10.2022 czemu podświetla?
    }

    @Test
    public void getShouldGetObjectOnSpecificIndex() {// CHECK: 15.10.2022
        addManyTheSameElementsToList(10);
        Assertions.assertEquals("0", elements.get(0));
        Assertions.assertEquals("1", elements.get(elements.size() - 1));
        Assertions.assertEquals("0", elements.get(5));
    }

    @Test
    public void containsShouldCheckIfObjectIsInList() {// CHECK: 15.10.2022
        addManyTheSameElementsToList(10);
        Assertions.assertTrue(elements.contains("0"));
        Assertions.assertTrue(elements.contains("1"));
        Assertions.assertFalse(elements.contains("-1"));
        Assertions.assertFalse(elements.contains("20"));

    }

    @Test
    public void toArrayShouldReturnArray() { // CHECK: 15.10.2022
        addManyTheSameElementsToList(10);
        String[] array = new String[10];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = 0 + "";
        }
        array[9] = 1 + "";
        Assertions.assertEquals(array.length, elements.toArray().length);
        Assertions.assertEquals(array[0], elements.toArray()[0]);
        Assertions.assertEquals(array[5], elements.toArray()[5]);
        Assertions.assertEquals(array[array.length - 1], elements.toArray()[elements.toArray().length - 1]);
    }

    @Test
    public void setShouldSetObjectInSpecificIndex() {// CHECK: 17.10.2022 dlaczego nie działa na zwykłej ArrayLiście
        addManyTheSameElementsToList(10);
        Assertions.assertEquals("50", elements.set(3, "50"));
    }

    @Test
    public void addShouldAddElementOnSpecificPosition() {// CHECK: 17.10.2022
        addDifferentsElementsToList(10);
        elements.add(5, "100");
        Assertions.assertEquals("100", elements.get(5));
        Assertions.assertEquals(11, elements.size());
        Assertions.assertEquals("0", elements.get(0));
        Assertions.assertEquals("9", elements.get(elements.size() - 1));
    }

    @Test
    public void removeShouldDeleteElementOnSpecificIndex() {// CHECK: 17.10.2022
        addDifferentsElementsToList(20);
        Assertions.assertEquals("19", elements.remove(19));
        Assertions.assertEquals("5", elements.remove(5));
        Assertions.assertEquals("0", elements.remove(0));
    }

    @Test
    public void indexOfShouldReturnIndexOfObject() {
        addDifferentsElementsToList(15);
        Assertions.assertEquals(-1, elements.indexOf("15"));
        Assertions.assertEquals(0, elements.indexOf("0"));// CHECK: 17.10.2022 dlaczego nie działa?
        Assertions.assertEquals(10, elements.indexOf("10"));
        Assertions.assertEquals(14, elements.indexOf("14"));
    }
}
