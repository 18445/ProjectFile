package com.MOBA;

public class Weapon {
    private static int addefValue;
    private static int addefPer;
    private static int apdefValue;
    private static int apdefPer;
    private static int ad;
    private static int ap;
    private static int hp;
    private static int addef;
    private static int apdef;
    private static int price;
    private Player player;

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Weapon(int addefValue, int addefPer, int apdefValue, int apdefPer, int ad, int ap, int hp, int addef, int apdef,int price) {
        this.addefValue = addefValue;
        this.addefPer = addefPer;
        this.apdefValue = apdefValue;
        this.apdefPer = apdefPer;
        this.ad = ad;
        this.ap = ap;
        this.hp = hp;
        this.addef = addef;
        this.apdef = apdef;
        this.price = price;
    }
    public void setPlayer(Player player){
        this.player = player;
        set(player);//装备属性给英雄
    }
    public Player getPlayer() {
        return player;
    }



    public int getAd() {
        return ad;
    }

    public int getAp() {
        return ap;
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

    public int getPrice() {
        return price;
    }

    public int getHp() {
        return hp;
    }

    public int getAddef() {
        return addef;
    }

    public int getApdef() {
        return apdef;
    }

    public String getName() {
        return name;
    }

    public int getApdefPer() {
        return apdefPer;
    }

    public static void set(Player player){//加属性
        player.setAd( ad + player.getAd());
        player.setHp( hp + player.getHp());
        player.setAddef(ad + player.getAd());
        player.setAp(ap + player.getAp());
        player.setApdef(apdef + player.getApdef());
        player.setAddefPer(addefPer + player.getAddefPer());
        player.setApdefPer(apdefPer + player.getApdefPer());
        player.setAddefValue(addefValue + player.getAddefValue());
        player.setApdefValue(apdefValue + player.getApdefValue());
    }

}

class DoranBlade extends Weapon{



    private DoranBlade(int addefValue, int addefPer, int apdefValue, int apdefPer, int ad, int ap, int hp, int addef, int apdef,int price) {
        super(addefValue, addefPer, apdefValue, apdefPer, ad, ap, hp, addef, apdef,price);
    }
    private final static DoranBlade doranBlade = new DoranBlade(5,0,0,0,150,0,300,0,0,450);

    public static DoranBlade getDoranBlade() {
        doranBlade.setName("DoranBlade");
        return doranBlade;
    }

}
class DoranShiled extends Weapon{
    private static final String name = "DoranShiled";
    private DoranShiled(int addefValue, int addefPer, int apdefValue, int apdefPer, int ad, int ap, int hp, int addef, int apdef,int price) {
        super(addefValue, addefPer, apdefValue, apdefPer, ad, ap, hp, addef, apdef,price);
    }
    private final static DoranShiled doranShiled = new DoranShiled(0,0,0,0,0,0,521,55,45,450);

    public static DoranShiled getDoranShiled() {
        doranShiled.setName("DoranShiled");
        return doranShiled;
    }
}
class PickAxe extends Weapon{
    private static final String name = "PickAxe";
    private PickAxe(int addefValue, int addefPer, int apdefValue, int apdefPer, int ad, int ap, int hp, int addef, int apdef,int price) {
        super(addefValue, addefPer, apdefValue, apdefPer, ad, ap, hp, addef, apdef,price);
    }
    private final static PickAxe pickAxe = new PickAxe(0,0,100,80,0,85,0,0,0,850);

    public static PickAxe getPickAxe() {
        pickAxe.setName(" PickAxe ");
        return pickAxe;
    }
}
class BFsword extends Weapon{
    private static final String name = "BFsword";
    private BFsword(int addefValue, int addefPer, int apdefValue, int apdefPer, int ad, int ap, int hp, int addef, int apdef,int price) {
        super(addefValue, addefPer, apdefValue, apdefPer, ad, ap, hp, addef, apdef,price);
    }
    private final static BFsword bfsword = new BFsword(150,50,0,0,1024,0,256,0,0,1300);

    public static BFsword getBFsword() {
        bfsword.setName("BFsword");
        return bfsword;
    }
}
class ChainVest extends Weapon{
    private static final String name = "ChianVest";
    private ChainVest(int addefValue, int addefPer, int apdefValue, int apdefPer, int ad, int ap, int hp, int addef, int apdef,int price) {
        super(addefValue, addefPer, apdefValue, apdefPer, ad, ap, hp, addef, apdef,price);
    }
    private final static ChainVest chainVest = new ChainVest(0,0,0,0,0,0,2500,150,0,800);

    public static ChainVest getChainVest() {
        chainVest.setName("ChainVest");
        return chainVest;
    }
}
class NegatronCloack extends Weapon{
    private static final String name = "NegatronCloack";
    private NegatronCloack(int addefValue, int addefPer, int apdefValue, int apdefPer, int ad, int ap, int hp, int addef, int apdef,int price) {
        super(addefValue, addefPer, apdefValue, apdefPer, ad, ap, hp, addef, apdef,price);
    }
    private final static NegatronCloack negatronCloack = new NegatronCloack(0,0,0,0,0,0,2500,0,250,720);

    public static NegatronCloack getNegatronCloack() {
        negatronCloack.setName("NegatronCloack");
        return negatronCloack;
    }
}










