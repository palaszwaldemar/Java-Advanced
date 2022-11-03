package com.wp.collections;

public class MyNode<T> {
    private T object;
    private MyNode<T> nextMyNode;

    public MyNode(T object) {
        this.object = object;
    }

    public void setNextMyNode(MyNode<T> nextMyNode) {
        this.nextMyNode = nextMyNode;
    }

    public T getObject() {
        return object;
    }

    public MyNode<T> getNextMyNode() {
        return nextMyNode;
    }

    public boolean isLast() {
        return nextMyNode == null;
    }
}
