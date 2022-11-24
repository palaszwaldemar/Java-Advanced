package com.wp.collections;

import java.util.*;

public class MyLinkedList<T> implements List<T> {
    private MyNode<T> head;//firstNode

    @Override
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

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
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

    @Override
    public Iterator<T> iterator() {
        return new MyIteratorLinkedList<>(this);
    }

    @Override
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

    @Override
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

    @Override
    public T get(int index) {
        MyNode<T> actualNode = head;
        for (int i = 0; i < index; i++) {
            actualNode = actualNode.getNextMyNode();
        }
        return actualNode.getObject();
    }

    @Override
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

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            return null;
        }
        MyNode<T> actualNode = head;
        for (int i = 0; i < index; i++) {
            actualNode = actualNode.getNextMyNode();
        }
        T oldElement = actualNode.getObject();
        actualNode.setObject(element);
        return oldElement;
    }

    @Override
    public void add(int index, T element) {
        MyNode<T> myNode = head;
        MyNode<T> myNodeToAdd = new MyNode<>(element);
        if (index == 0) {
            myNode.setNextMyNode(head);
            head = myNodeToAdd;
        }
        for (int i = 0; i < index - 1; i++) {//pętla, która iteruje do elementu poprzedzającego element do usunięcia
            myNode = myNode.getNextMyNode();
        }
        MyNode<T> myNodeAfterNodeToAdd = myNode.getNextMyNode();
        myNode.setNextMyNode(myNodeToAdd);
        myNodeToAdd.setNextMyNode(myNodeAfterNodeToAdd);
    }

    @Override
    public T remove(int index) {
        MyNode<T> myNode = head;
        if (index == 0) {
            head = myNode.getNextMyNode();
            return myNode.getObject();
        }

        for (int i = 0; i < index - 1; i++) {//pętla, która iteruje do elementu poprzedzającego element do usunięcia
            myNode = myNode.getNextMyNode();
        }
        MyNode<T> myNodeBeforeNodeToDelete = myNode;
        MyNode<T> myNodeToDelete = myNode.getNextMyNode();

        myNodeBeforeNodeToDelete.setNextMyNode(myNodeToDelete.getNextMyNode());
        return myNodeToDelete.getObject();
    }

    @Override
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