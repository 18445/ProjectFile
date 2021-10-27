package com.Level0;

public class Refrigerator implements Box{
    private String name ="冰箱";
    public String getName(){
        return name;
    }
    public void move(Animals animals){
        System.out.println(animals.getName()+"被冰箱装");
    }
}

