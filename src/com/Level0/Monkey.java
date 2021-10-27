package com.Level0;

public class Monkey extends Animals {
    private String name ="猴子";
    public String getName() {
        return this.name;
    }
    public void enter(Box box) {
        box.move(this);
    }
}
