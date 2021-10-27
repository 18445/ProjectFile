package com.MOBA;
//角色类
public class Actor {
    private String name;
    private int hp;
    private int ad;
    private int addef;
    private int ap;
    private int apdef;
    private int addefValue; //ad固定穿透
    private int addefPer;   //ad百分比穿透
    private int apdefValue;
    private int apdefPer;
    private int exp;
    public Actor(){

    }
    public Actor(String name, double hp, int ad, int addef, int ap, int apdef) {
    }
    public int getAddefValue() {
        return addefValue;
    }

    public int getAddefPer() {
        return addefPer;
    }

    public int getApdefValue() {
        return apdefValue;
    }

    public int getApdefPer() {
        return apdefPer;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setAddefValue(int addefValue) {
        this.addefValue = addefValue;
    }

    public void setAddefPer(int addefPer) {
        this.addefPer = addefPer;
    }

    public void setApdefValue(int apdefValue) {
        this.apdefValue = apdefValue;
    }

    public void setApdefPer(int apdefPer) {
        this.apdefPer = apdefPer;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getAddef() {
        return addef;
    }

    public int getAp() {
        return ap;
    }

    public int getApdef() {
        return apdef;
    }

    public void setAddef(int addef) {
        this.addef = addef;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public void setApdef(int apdef) {
        this.apdef = apdef;
    }

    public int getAd() {
        return ad;
    }

}
