package com.Level0;

public class Oven implements Box{
    private String name = "烤箱";
    public String getName(){
        return name;
    }
    public void move(Animals animals) {
        System.out.println(animals.getName()+"被烤箱装");
    }
    public  void dry(Animals animals){
        System.out.println(animals.getName() + "被烤箱烤");
    }
}
