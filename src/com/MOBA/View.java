package com.MOBA;

public class View implements List{
    private final static Weapon weapon[] = new Weapon[6];
    static {//装备信息
        weapon[0] = DoranBlade.getDoranBlade();
        weapon[1] = DoranShiled.getDoranShiled();
        weapon[2] = PickAxe.getPickAxe();
        weapon[3] = BFsword.getBFsword();
        weapon[4] = ChainVest.getChainVest();
        weapon[5] = NegatronCloack.getNegatronCloack();
    }
    public static void weapon(Weapon weapon[]){
        for (int i = 0;i< weapon.length;i++){
            List.WeaponList(weapon[i]);
        }
    }

    public static Weapon[] getWeapon() {
        return weapon;
    }
}
interface List{//调出角色信息
     static void WeaponList(Weapon weapon){//调出武器属性
         System.out.println(weapon.getName()+"的属性如下：");
         if(weapon.getAd() != 0){
         System.out.println("武器的攻击力："+weapon.getAd());}
         if(weapon.getAp() != 0){
         System.out.println("武器的法强："+weapon.getAp());}
         if(weapon.getHp() != 0){
         System.out.println("装备提供血量："+weapon.getHp());}
         if(weapon.getAddef() != 0){
         System.out.println("装备提供护甲："+ weapon.getAddef());}
         if(weapon.getApdef() != 0){
         System.out.println("装备提供魔抗："+ weapon.getApdef());}
         if(weapon.getAddefPer() != 0){
         System.out.println("武器的攻击力百分比穿透："+weapon.getAddefPer());}
         if(weapon.getApdefPer() != 0){
         System.out.println("武器的法强百分比穿透："+weapon.getApdefPer());}
         if(weapon.getAddefValue() != 0){
         System.out.println("武器的攻击力固定穿透："+weapon.getAddefValue());}
         if(weapon.getApdefValue() != 0){
         System.out.println("武器的法强固定穿透："+weapon.getApdefValue());}
         if(weapon.getPlayer() == null){
             System.out.println("未购买");
             System.out.print("武器的价格为："+weapon.getPrice());
             if (Player.getInstance().getMoney()>weapon.getPrice()){
             System.out.println("(可购买)");
            }else{
                 System.out.println("(不可购买)");
             }
         }else {
             System.out.println("已装备");
         }
         System.out.println("************");
     }

    static void playerView(Actor actor) {
        System.out.println("***************");
        System.out.println(actor.getName()+"的属性如下：");
        if(actor instanceof Player){//判断是否是玩家的父类
            System.out.println("玩家等级是："+Player.getLevel());
        }
        System.out.println("攻击力："+actor.getAd());
        System.out.println("法强："+actor.getAp());
        System.out.println("固定AD穿透："+actor.getAddef());
        System.out.println("百分比AD穿透:"+actor.getAddefPer());
        System.out.println("固定AP穿透："+actor.getApdef());
        System.out.println("百分比AP穿透:"+actor.getApdefPer());
        System.out.println("AD护甲："+actor.getAddef());
        System.out.println("AP护甲："+actor.getApdef());
        System.out.println("***************");
    }
    static void playerView(Actor actor[]) {
         for(int i =0;i<actor.length&&actor[i]!=null;i++){
        System.out.println("***************");
        System.out.println(actor[i].getName()+"的属性如下：");
        System.out.println("攻击力："+actor[i].getAd());
        System.out.println("法强："+actor[i].getAp());
        System.out.println("固定AD穿透："+actor[i].getAddef());
        System.out.println("百分比AD穿透:"+actor[i].getAddefPer());
        System.out.println("固定AP穿透："+actor[i].getApdef());
        System.out.println("百分比AP穿透:"+actor[i].getApdefPer());
        System.out.println("AD护甲："+actor[i].getAddef());
        System.out.println("AP护甲："+actor[i].getApdef());
        System.out.println("***************");
    }
     }
}