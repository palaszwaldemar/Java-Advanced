package com.wp.collections;

public class Box<T> {
    private T object;

    void add(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}
