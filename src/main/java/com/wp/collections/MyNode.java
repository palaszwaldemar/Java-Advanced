package com.wp.collections;

public class MyNode<T> {
    private final T object;
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

    public boolean isNotLast() {
        return nextMyNode != null; // CHECK : 19.11.2022 zmieniłem na "!=" z "==" bo tak podpowiedział intellij, dlaczego?
    }
}
