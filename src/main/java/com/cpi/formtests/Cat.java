package com.cpi.formtests;

public class Cat {

    private final String name;
    private int eatenMouseTotal = 0;

    public Cat(String name) {
        this.name = name;
    }

    public void catchMouse(int nbMouse) {
        eatenMouseTotal += nbMouse;
    }

    public String getName() {
        return name;
    }

    public int getEatenMouseTotal() {
        return eatenMouseTotal;
    }
}
