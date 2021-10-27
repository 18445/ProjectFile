package com.Level0;

public class Tigers extends Animals {
    private String name = "老虎";
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void enter(Box box) {
        box.move(this);
    }
}
