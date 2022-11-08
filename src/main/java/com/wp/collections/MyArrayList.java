package com.wp.collections;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] tab = (T[]) new Object[10];
    // CHECK : 08.11.2022 nie działa wyświetlanie danych w liście po pętli

    @Override
    public int size() {
        int count = 0;
        for (T t : tab) {
            if (t != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
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

    @Override // TODO: 03.11.2022 poprawić. nie może zwaracać tablicy z nulami. Test  tej metody też do poprawy
    // CHECK : 08.11.2022 dlaczego nie może zwracać tablicy z nulami?
    public Object[] toArray() {
        return tab;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
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

    @Override
    public boolean remove(Object o) {// CHECK : 04.11.2022 sprawdzić
        T[] aditionalTab = (T[]) new Object[tab.length - 1];
        int iterAditionalTab = 0;
        for (T t : tab) {
            if (!t.equals(o)) {
                aditionalTab[iterAditionalTab] = t;
                iterAditionalTab++;
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
        for (Object o : c) {
            remove(o);
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object o : toArray()){
            if (!c.contains(o)) {
                remove(o);
            }
        }
        return false;
    }

    @Override
    public void clear() {
        tab = (T[]) new Object[10];
    }

    @Override
    public T get(int index) {
        return tab[index];
    }

    @Override
    public T set(int index, T element) {
        T previousElement = tab[index];
        tab[index] = element;
        return previousElement;
    }

    @Override // TODO: 03.11.2022 zmienić bez dodawania drugiej tablicy. Przeszukać od końca
    // CHECK : 08.11.2022 nie wiem jak zrobić bez dodawania dodatkowej tablicy
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

    @Override // TODO: 03.11.2022 zmienić tak jak wyżej
    // CHECK : 08.11.2022 jeżeli zorobię bez dodatkowej tablicy to na końcu zostanie null
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
