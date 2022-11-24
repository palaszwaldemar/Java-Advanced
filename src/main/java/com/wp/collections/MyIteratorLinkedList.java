package com.wp.collections;

import java.util.Iterator;

public class MyIteratorLinkedList<T> implements Iterator<T> {
    private final MyLinkedList<T> myLinkedList;
    private int index;

    public MyIteratorLinkedList(MyLinkedList<T> myLinkedList) {
        this.myLinkedList = myLinkedList;
    }

    @Override
    public boolean hasNext() {
        return index < myLinkedList.size();
    }

    @Override
    public T next() {
        return myLinkedList.get(index++);
    }
}
