package com.Level0;

public class Elephant extends Animals {
    private String name = "大象";
    public String getName() {
        return name;
    }
    public void enter(Box box) {
        box.move(this);
    }

}
