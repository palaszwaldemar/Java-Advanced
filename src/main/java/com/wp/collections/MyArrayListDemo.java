package com.wp.collections;

import java.util.ArrayList;
import java.util.List;

public class MyArrayListDemo {
    public static void main(String[] args) {
        List<String> text = new ArrayList<>();
        List<String> text1 = new MyArrayList<>();
        text1.add("kot");
        text.add("pies");
        System.out.println(text1.get(0));
        System.out.println(text.get(0));
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