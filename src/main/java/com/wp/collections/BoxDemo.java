package com.wp.collections;

import java.util.Random;

public class BoxDemo {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.add("text");
        System.out.println(box.getObject());
        String text = box.getObject();
        System.out.println(text.toUpperCase());


        Box<Random> box1 = new Box<>();
        box1.add(new Random());
        System.out.println(box1.getObject());
        Random random = box1.getObject();
        System.out.println(random.nextInt(5));
    }
}
