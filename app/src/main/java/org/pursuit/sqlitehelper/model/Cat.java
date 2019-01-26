package org.pursuit.sqlitehelper.model;

public class Cat {

    private int legs;
    private String color;
    private int tail;

    public Cat (int legs, String color, int tail) {
        this.legs = legs;
        this.color = color;
        this.tail = tail;
    }
    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int isTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

}
