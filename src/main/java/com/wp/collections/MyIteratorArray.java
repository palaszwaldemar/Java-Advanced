package com.wp.collections;

import java.util.Iterator;

public class MyIteratorArray<T> implements Iterator<T> {
    private final MyArrayList<T> myArrayList;
    private int index;

    public MyIteratorArray(MyArrayList<T> myArrayList) {
        this.myArrayList = myArrayList;
    }



    @Override
    public boolean hasNext() {
        return index  < myArrayList.size();
    }

    @Override
    public T next() {
        return myArrayList.get(index++);
    }
}
