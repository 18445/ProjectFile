package com.Level0;

public class Wardrobe implements Box{
    private String name ="衣柜";
    public String getName(){
        return name;
    }
    public void move(Animals animals){
        System.out.println(animals.getName()+"被衣柜装");
    }
}
