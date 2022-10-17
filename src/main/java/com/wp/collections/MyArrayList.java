package com.wp.collections;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] tab = (T[]) new Object[10];

    @Override// CHECK: 15.10.2022 zrobione na lekcji
    public int size() {
        int count = 0;
        for (T t : tab) {
            if (t != null) {
                count++;
            }
        }
        return count;
    }

    @Override// CHECK: 14.10.2022
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override// CHECK: 15.10.2022
    public boolean contains(Object o) {
        for (T t : tab) {
            if (t.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override// CHECK: 15.10.2022
    public Object[] toArray() {
        return tab;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override// CHECK: 15.10.2022 zrobione na lekcji
    public boolean add(T t) {
        if (tab.length == size()) {
            T[] additionalTab = (T[]) new Object[tab.length * 2];
            for (int i = 0; i < tab.length; i++) {
                additionalTab[i] = tab[i];
            }
            tab = additionalTab;
        }
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == null) {
                tab[i] = t;
                return true;
            }
        }
        return true;
    }

    @Override// CHECK: 15.10.2022
    public boolean remove(Object o) {
        T[] aditionalTab = (T[]) new Object[size()];
        int indexOfTab = 0;
        boolean wasRemoved = false;
        for (T t : tab) {
            if (!t.equals(o) || wasRemoved) {
                aditionalTab[indexOfTab] = t;
                indexOfTab++;
            } else {
                wasRemoved = true;
            }
        }
        tab = aditionalTab;
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

    @Override// CHECK: 15.10.2022
    public void clear() {
        tab = (T[]) new Object[10];
    }

    @Override// CHECK: 15.10.2022
    public T get(int index) {
        return tab[index];
    }

    @Override// CHECK: 15.10.2022
    public T set(int index, T element) {
        tab[index] = element;
        return tab[index];
    }

    @Override// CHECK: 17.10.2022
    public void add(int index, T element) {
        T[] aditionalTab = (T[]) new Object[tab.length + 1];
        boolean wasAdd = false;
        int tabIter = 0;
        for (int i = 0; i < aditionalTab.length; i++) {
            if (i != index || wasAdd) {
                aditionalTab[i] = tab[tabIter];
                tabIter++;
            } else {
                aditionalTab[i] = element;
                wasAdd = true;
            }
        }
        tab = aditionalTab;
    }

    @Override// CHECK: 17.10.2022
    public T remove(int index) {
        T removed = null;
        int aditionalTabIter = 0;
        T[] aditionalTab = (T[]) new Object[tab.length - 1];
        for (int i = 0; i < tab.length; i++) {
            if (i != index) {
                aditionalTab[aditionalTabIter] = tab[i];
                aditionalTabIter++;
            } else {
                removed = tab[i];
            }
        }
        tab = aditionalTab;
        return removed;
    }

    @Override // CHECK: 17.10.2022
    public int indexOf(Object o) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == null) {
                return -1;
            }
            if (tab[i].equals(o)) {
                return i;
            }
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
