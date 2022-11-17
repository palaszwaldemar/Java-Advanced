package com.wp.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyArrayListDemo {
    public static void main(String[] args) {
        List<String> text = new ArrayList<>();
        List<String> text1 = new MyArrayList<>();
        text1.add("kot");
        text1.add("osa");
        text.add("pies");
        text.add("lis");
        text.add("osa");
        text.add(null);
        //System.out.println(text1.get(0));
        //System.out.println(text.get(0));
        for (String s : text1) {
            System.out.println(s);
        }

        Iterator<String> iterator = text.iterator();
/*
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
*/
    }
}




//abstrakcyjne klasy:
//- nie mozna stworzyc obiektu
//- moga byc metody abstrakcyjne

//iterfejsy maja te same cechy co klasa anbstrakcyjna ale roznia sie od zwyklych klas tym ze:
//- interfejsy sie implementuje a nie dziedziczy
//- implementowac mozna wiele interfejsow
//- interjesy nie maja pol ani konstruktorow*
//- interfejsy maja tylko metody abstrakcyjne*

//* - w programowaniu funkcyjnym interfejsy łamią te zasady od nowszych wersji javy