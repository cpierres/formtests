package com.cpi.formtests;

public class Cat {
    private final String name;
    private int eatenMouseTotal = 0;

    public Cat(String name) {
        this.name = name;
    }

    public void catchMouse(int nbMouse) {
        eatenMouseTotal += nbMouse;
        System.out.println("         Cat.catchMouse("+nbMouse+") => eatenMouseTotal="+eatenMouseTotal);
    }

    public String getName() {
        return name;
    }

    public int getEatenMouseTotal() {
        System.out.println("         Cat.getEatenMouseTotal() => " + eatenMouseTotal);
        return eatenMouseTotal;
    }
}
