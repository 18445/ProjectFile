package com.Level0;

public class WashingMachine implements Box{
    private String name = "洗衣机";
    public String getName(){
        return name;
    }
    public void move(Animals animals) {
        System.out.println(animals.getName()+"被洗衣机装");
    }
    public void Wash(Animals animals){
        System.out.println(animals.getName()+"被洗衣机洗");
    }
}
