package com.wp.collections;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] tab = (T[]) new Object[10];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (tab[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] aditionalTab = new Object[size];
        System.arraycopy(tab, 0, aditionalTab, 0, size);
        return aditionalTab;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {// CHECK : 15.11.2022 w wersji wyszarzonej nie działało. Czy teraz jest dobrze?
        /*for (int i = 0; i < tab.length; i++) {
            if (tab[i] == null) {
                tab[i] = t;
                size++;
                return true;// jeżeli znajdzie nulla to następny if się nie wykona i tablica nie zostanie zwiększona
            }
        }
        if (tab.length == size) {
            T[] additionalTab = (T[]) new Object[tab.length * 2];
            for (int i = 0; i < tab.length; i++) {
                additionalTab[i] = tab[i];
            }
            tab = additionalTab;
        }
        return true;*/

        T[] additionalTab = (T[]) new Object[tab.length * 2];
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == null) {
                tab[i] = t;
                size++;
                if (tab.length == size) {
                    System.arraycopy(tab, 0, additionalTab, 0, tab.length);
                    tab = additionalTab;
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        size--;
        boolean wasAdd = false;
        for (int i = 0; i < size; i++) {
            if (tab[i].equals(o) || wasAdd) {
                tab[i] = tab[i + 1];
                wasAdd = true;
            }
        }
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
        for (Object o : c) {
            remove(o);
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object o : toArray()) {
            if (!c.contains(o)) {
                remove(o);
            }
        }
        return false;
    }

    @Override
    public void clear() {
        tab = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public T get(int index) {
        if (tab[index] != null) {
            return tab[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public T set(int index, T element) {
        T previousElement = tab[index];
        tab[index] = element;
        return previousElement;
    }

    @Override
    public void add(int index, T element) {
        for (int i = size; i >= 0; i--) {
            if (i > index) {
                tab[i + 1] = tab[i];
            } else {
                tab[i + 1] = tab[i];
                tab[i] = element;
                size++;
                return;
            }
        }
    }

    @Override
    public T remove(int index) {
        T removed = tab[index];
        size--;
        for (int i = 0; i < size; i++) {
            if (i >= index) {
                tab[i] = tab[i + 1];
            }
        }
        return removed;
    }

    @Override
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
