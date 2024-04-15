package org.main;

public class Main {
    public static void main(String[] args) {
        IntegerArrayList list = new IntegerArrayList();
        list.add(10);
        list.add(20);
        list.add(30);

        list.set(50, 1);
        list.remove(1);
    }
}