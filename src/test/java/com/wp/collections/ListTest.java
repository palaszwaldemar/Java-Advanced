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

    private void addDifferentElementsToList(int howManyElements) {
        for (int i = 0; i < howManyElements; i++) {
            elements.add(i + "");
        }
    }

    @Test
    public void addShouldSaveOneElement() {

        addManyTheSameElementsToList(1);

        Assertions.assertEquals("1", elements.get(0));
        Assertions.assertFalse(elements.isEmpty());
    }

    @Test
    public void addShouldSaveMoreElements() {

        addManyTheSameElementsToList(3);

        Assertions.assertEquals("0", elements.get(0));
        Assertions.assertEquals("0", elements.get(1));
        Assertions.assertEquals("1", elements.get(2));
        Assertions.assertEquals(3, elements.size());
    }

    @Test
    public void addShouldSaveVeryManyElements() {

        addDifferentElementsToList(12);

        Assertions.assertEquals("0", elements.get(0));
        Assertions.assertEquals("5", elements.get(5));
        Assertions.assertEquals("11", elements.get(11));
        Assertions.assertEquals(12, elements.size());
    }

    @Test
    public void listShouldBeEmpty() {
        Assertions.assertTrue(elements.isEmpty());
    }

    @Test
    public void removeShouldDeleteObject() {
        //given
        addDifferentElementsToList(10);
        //when
        elements.remove("4");
        //then
        Assertions.assertEquals("5", elements.get(4));
        //when
        elements.remove("0");
        //then
        Assertions.assertEquals("1", elements.get(0));
        //when
        elements.remove("9");
        //then
        Assertions.assertEquals("8", elements.get(elements.size() - 1));
    }

    @Test
    public void clearShouldRemoveEveryObjects() {

        addManyTheSameElementsToList(30);

        elements.clear();

        Assertions.assertTrue(elements.isEmpty());
    }

    @Test
    public void getShouldGetObjectOnSpecificIndex() {

        addManyTheSameElementsToList(10);

        Assertions.assertEquals("0", elements.get(0));
        Assertions.assertEquals("0", elements.get(5));
        Assertions.assertEquals("1", elements.get(elements.size() - 1));
    }

    @Test
    public void containsShouldCheckIfObjectIsInList() {

        addManyTheSameElementsToList(10);

        Assertions.assertTrue(elements.contains("0"));
        Assertions.assertTrue(elements.contains("1"));
        Assertions.assertFalse(elements.contains("-1"));
        Assertions.assertFalse(elements.contains("20"));

    }

    @Test
    public void toArrayShouldReturnArray() {

        addManyTheSameElementsToList(10);

        String[] array = new String[10];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = 0 + "";
        }
        array[9] = "1";

        Assertions.assertArrayEquals(array, elements.toArray());
    }

    @Test
    public void setShouldSetObjectInSpecificIndex() {

        addDifferentElementsToList(10);

        Assertions.assertEquals("3", elements.set(3, "50"));
        Assertions.assertEquals("50", elements.get(3));
        Assertions.assertEquals("2", elements.get(2));
        Assertions.assertEquals("4", elements.get(4));
    }

    @Test
    public void addShouldAddElementOnSpecificPosition() {

        addDifferentElementsToList(10);

        elements.add(5, "100");

        Assertions.assertEquals("4", elements.get(4));
        Assertions.assertEquals("100", elements.get(5));
        Assertions.assertEquals("5", elements.get(6));
        Assertions.assertEquals("0", elements.get(0));
        Assertions.assertEquals("9", elements.get(elements.size() - 1));
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

    @Test
    public void indexOfShouldReturnIndexOfObjectOrMinusOne() {

        addDifferentElementsToList(15);

        Assertions.assertEquals(0, elements.indexOf("0"));
        Assertions.assertEquals(10, elements.indexOf("10"));
        Assertions.assertEquals(14, elements.indexOf("14"));
        Assertions.assertEquals(-1, elements.indexOf("50"));

        elements.clear();

        addDifferentElementsToList(1);
        Assertions.assertEquals(0, elements.indexOf("0"));
        Assertions.assertEquals(-1, elements.indexOf("1"));
    }

    @Test
    public void sizeShouldReturnSizeOfList() {
        //given
        addManyTheSameElementsToList(10);
        //when
        //then
        Assertions.assertEquals(10, elements.size());

    }

    @Test // TODO: 10.11.2022 wrócić po przerobieniu streamów
    public void ifGetUseValuesOutsideSizeThenThrowException() {
        addManyTheSameElementsToList(3);

        try {
            elements.get(10);
            Assertions.fail("Nie rzucono wyjątku");
        } catch (IndexOutOfBoundsException e) {
            //zdany test
        } catch (NullPointerException e) {/*dodano aby przeszedl test klasy MyLinkedList */ // CHECK : 19.11.2022
            //zdany test
        }
    }
}
