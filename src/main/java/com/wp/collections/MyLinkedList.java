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

    @Override // TODO: 19.11.2022
    public Iterator<T> iterator() {
        return null;
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

    @Override // TODO: 18.11.2022 dokończyć
    public T set(int index, T element) {
        return null;
    }

    @Override // TODO: 19.11.2022
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
        // TODO: 20.11.2022 dodać instrukcje w przypadku gdy myNode jest ostatnie lub lista jest jednoelementowa
    }

    @Override // CHECK : 19.11.2022
    public T remove(int index) {
        MyNode<T> myNode = head;
        int count = 0;
        MyNode<T> myNodeToDelete = myNode;
        while (myNode.isNotLast()) {
            if (count == index - 1) {
                myNodeToDelete = myNode.getNextMyNode();
                MyNode<T> secondMyNode = myNode.getNextMyNode();
                myNode.setNextMyNode(secondMyNode);
            }
            myNode = myNode.getNextMyNode();
            count++;
        }
        /*if (index == 0) {
            head = myNode.getNextMyNode();
            return myNode.getObject();
        }
        for (int i = 0; i < index - 1; i++) {//pętla, która iteruje do elementu poprzedzającego element do usunięcia
            myNode = myNode.getNextMyNode();
        }
        MyNode<T> deletedMyNode = myNode.getNextMyNode();
        MyNode<T> secondMyNode = myNode;
        for (int i = 0; i < 2; i++) {//pętla, ktora iteruje (od elementu poprzedzającego element do usunięcia) do
            //elementu nastęnego po elemencie do usunięcia
            secondMyNode = secondMyNode.getNextMyNode();
        }
        myNode.setNextMyNode(secondMyNode);*/
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