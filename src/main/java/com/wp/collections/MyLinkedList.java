package com.wp.collections;

import java.util.*;

// CHECK : 19.11.2022 jak działa debugger?
public class MyLinkedList<T> implements List<T> {
    private MyNode<T> head;//firstNode

    @Override // CHECK : 09.11.2022
    public int size() {
        int count = 0;
        MyNode<T> actualNode = head;
        while (actualNode.isNotLast()) {
            actualNode = actualNode.getNextMyNode();
            count++;
        }
        count++;
        return count;
    }

    @Override // CHECK : 09.11.2022
    public boolean isEmpty() {
        return head == null;
    }

    @Override // CHECK : 18.11.2022
    public boolean contains(Object o) {
        MyNode<T> actualNode = head;
        while (actualNode.isNotLast()) {
            if (actualNode.getObject().equals(o)) {
                return true;
            }
            actualNode = actualNode.getNextMyNode();
        }
        return actualNode.getObject().equals(o);
    }

    @Override // CHECK : 23.11.2022
    public Iterator<T> iterator() {
        return new MyIteratorLinkedList<>(this);
    }

    @Override // CHECK : 17.11.2022
    public Object[] toArray() {
        Object[] array = new Object[size()];
        int indexOfArray = 0;
        MyNode<T> actualNode = head;
        array[indexOfArray++] = actualNode.getObject();
        while (actualNode.isNotLast()) {
            actualNode = actualNode.getNextMyNode();
            array[indexOfArray] = actualNode.getObject();
            indexOfArray++;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override // CHECK : 17.11.2022
    public boolean add(T t) {
        if (head == null) {
            head = new MyNode<>(t);
            return true;
        }
        MyNode<T> actualNode = head;
        while (actualNode.isNotLast()) {
            actualNode = actualNode.getNextMyNode();
        }
        actualNode.setNextMyNode(new MyNode<>(t));
        return true;
    }

    @Override // CHECK : 17.11.2022
    public T get(int index) {
        MyNode<T> actualNode = head;
        for (int i = 0; i < index; i++) {
            actualNode = actualNode.getNextMyNode();
        }
        return actualNode.getObject();
    }

    @Override // CHECK : 19.11.2022
    public boolean remove(Object o) {
        remove(indexOf(o));
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override // CHECK : 17.11.2022
    public void clear() {
        head = null;
    }

    @Override // CHECK : 23.11.2022 nie działa. nie mam pomysłu jak zrobić
    public T set(int index, T element) {
        MyNode<T> myNode = head;
        MyNode<T> myNodeToSet = new MyNode<>(element);
        if (index == 0) {
            head = myNodeToSet;
            return myNode.getObject();
        }
        for (int i = 0; i < index - 1; i++) {//pętla, która iteruje do elementu poprzedzającego element do usunięcia
            myNode = myNode.getNextMyNode();
        }
        MyNode<T> myNodeToDelete = myNode.getNextMyNode();
        myNode.setNextMyNode(myNodeToSet);
        myNodeToSet.setNextMyNode(myNode.getNextMyNode().getNextMyNode());
        return myNodeToDelete.getObject();
    }

    @Override
    public void add(int index, T element) {
        MyNode<T> myNode = head;
        MyNode<T> myNodeToAdd = new MyNode<>(element);
        int count = 0;
        while (myNode.isNotLast()) {
            if (count == index - 1) {
                MyNode<T> aditionalMyNode = myNode.getNextMyNode();
                myNode.setNextMyNode(myNodeToAdd);
                myNodeToAdd.setNextMyNode(aditionalMyNode);
                return;
            }
            myNode = myNode.getNextMyNode();
            count++;
        }
        // CHECK : 23.11.2022 nie wiem jak dodać warunek w przypadku gdy lista jest jednoelementowa lub gdy myNode jest ostatni
    }

    @Override // CHECK : 19.11.2022
    public T remove(int index) {
        MyNode<T> myNode = head;
        if (index == 0) {
            head = myNode.getNextMyNode();
            return myNode.getObject();
        }
        for (int i = 0; i < index - 1; i++) {//pętla, która iteruje do elementu poprzedzającego element do usunięcia
            myNode = myNode.getNextMyNode();
        }
        MyNode<T> myNodeToDelete = myNode.getNextMyNode();
        MyNode<T> myNodeNextAfterMyNodeToDelete = myNode;
        for (int i = 0; i < 2; i++) {//pętla, ktora iteruje (od elementu poprzedzającego element do usunięcia) do
                                    //elementu nastęnego po elemencie do usunięcia
            myNodeNextAfterMyNodeToDelete = myNodeNextAfterMyNodeToDelete.getNextMyNode();
        }
        myNode.setNextMyNode(myNodeNextAfterMyNodeToDelete);
        return myNodeToDelete.getObject();
    }

    @Override // CHECK : 19.11.2022
    public int indexOf(Object o) {
        int index = 0;
        MyNode<T> myNode = head;
        while (myNode.isNotLast()) {
            if (myNode.getObject().equals(o)) {
                return index;
            }
            myNode = myNode.getNextMyNode();
            index++;
        }
        if (myNode.getObject().equals(o)) {
            return index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {

        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
//[ a, b, c, d, e, f]
//[a][b][c][x][d][e][f]
//[x]