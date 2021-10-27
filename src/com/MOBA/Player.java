package com.MOBA;
//主角

import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Player extends Actor implements Attack,IsAlive,attribute,Choice{//单例设计游戏角色
    private Warrior warrior;
    private static int Level;
    boolean shop = false;//是否被商店老板鄙视
    public int getExp() {
        return exp;
    }
    private int money;
    private int exp;
    private static Weapon weapons[];
    public static int getLevel() {
        return Level;
    }
    //创建游戏角色;
    static {
        System.out.println("请输入游戏角色名字:");
    }
    public void changeShop(){
        shop = true;
    }
    public static Scanner getIn() {
        return in;
    }
    public static String getN() {
        return n;
    }
    public static Player getPlayer() {
        return player;
    }
    static Scanner in =new Scanner(System.in);
        static String n = in.next();
        private static Player player  = new Player();

    public static void setLevel(int level) {
        Level = level;
    }

        int originAd = 30;
        int originAp = 15;
        int originAddef = 10;
        int originApdef = 10;
        int originHp = 500;
    {//初始化人物属性

        setName(n);
        setAd(originAd);
        setAp(originAp);
        setApdef(originApdef);
        setAddef(originAddef);
        setHp(originHp);
        setLevel(1);
    }
    public static void setWeapons(Weapon[] weapons) {
        Player.weapons = weapons;
    }

    private Player(String name, int hp, int ad, int addef, int ap, int apdef, int Level) {
        super(name, hp, ad,  addef, ap, apdef);
        this.Level = Level;
    }
    public Player(){

    }


    public static Player getInstance(){
            return player;
    }
    public void changeMoney(int money){
        this.money += money;
    }

    @Override
    public void beAttack() {
        System.out.println("！！！！！！！！");
        System.out.println("！！察觉异常！！");
        System.out.println("！！ 被攻击 ！！");
        System.out.println("！！！！！！！！");
    }

    @Override
    public void isAlive() {//角色死亡时游戏结束
        System.out.println("游戏结束，角色死亡");
        System.exit(0);
    }


    public Warrior getWarrior() {
        return warrior;
    }

    public int getMoney() {
        return money;
    }

    public static Weapon[] getWeapons() {
        return weapons;
    }

    public void alive(IsAlive isAlive){
        isAlive.isAlive();
    }
    //传入小兵
    public void setWarrior(Warrior warrior){
        this.warrior = warrior;
    }
    //判断
    public void judge(Actor actor){
        player.judge(warrior,actor);
    }

    //接口回调
    //判断小兵是否存活
    public void judge(IsAlive isAlive,Actor actor){
        if(actor.getHp()<=0){
//            isAlive();
            setWarrior((Warrior)actor);
            System.out.println("小兵被击杀");
            player.addMoney(warrior.getPrice());
            System.out.println("金钱增加："+ warrior.getPrice());
            int Hp = (int)(10+Math.random()*90);//击杀小兵恢复血量.
            Player.getInstance().ChangeHp(Hp);
            System.out.println(Player.getInstance().getName()+"恢复血量"+Hp);

        }else{
            System.out.println("小兵存活");
        }
    }
    public void addMoney(int x){
        money += x;
    }
    public void addExp(int x){
        exp += x;
    }

    @Override
    public void changLevel(int n) {
        Level += n;
    }

    @Override
    public void ChangeHp(int n) {
        super.setHp(super.getHp()+n);
    }

    public void Escape(){//最后逃跑
        System.out.println("在面对最终敌人时"+player.getName()+" 选择了逃避");
        System.out.println(player.getName()+" 失去了获得胜利的方式");
        System.out.println(player.getName()+" 在后半生只能在逃避中度过");
        System.out.println("在许多年之后，面对即将到来的死亡,"+player.getName()+"将会回想起，他自己做出选择的那天");
        System.out.println("The end");
        System.out.println("");
        System.out.println("--------------------------------------------");
        System.exit(0);
    }
    @Override
    public void Escape(Warrior warrior[]) {
        int x = (int)(Math.random()*5);
        switch(x){
            case 0://逃跑中被击中
                System.out.println("在逃跑路中，"+Player.getInstance().getName()+"不幸被击中");
                int y = warrior.length;//人数
                int z = (int)(Math.random()*y);
                for(int i =0;i<z;i++) {//随机被击中
                    int random = (int)(Math.random()*y);
                    Attack.adattack(warrior[random],Player.getInstance());
                    Attack.apattack(warrior[random],Player.getInstance());
                    break;
                }
            case 1://逃跑成功
                System.out.println("在逃跑路中，"+Player.getInstance().getName()+" 因为小兵的不留神，成功逃跑");
                System.out.println("因为面对小兵逃跑，你收到了来自商店老板的鄙视");
                System.out.println("你的Hp-1");
                Player.getInstance().changeShop(); ;
                Player.getInstance().ChangeHp( - 1);
                System.out.println("你的生命值为："+player.getHp());
                break;
            case 3://被帮助
                System.out.println("在逃跑路中，"+Player.getInstance().getName()+" 被神秘人获救");
                for(int i = 0;i< warrior.length;i++){
                    Attack.adattack(unknow.getInstance(),warrior[i]);
                }
                System.out.println("神秘人在你还没开口前离去");
                break;
            case 4://运气
                int Weapon = weapons.length;//武器数量
                int W = (int)(Math.random()*Weapon);
                weapons[W].setPlayer(player);
                System.out.println("在逃跑路上，"+Player.getInstance().getName()+" 幸运捡到了一个装备");
                System.out.println("你装备了"+weapons[W].getName());
                break;
            case 5://逃跑失败
                System.out.println("在逃跑路中，"+Player.getInstance().getName()+" 被石头绊了一跤，逃脱失败");
                System.out.println("你被小兵再次攻击");
                for(int i = 0;i< warrior.length;i++){
                    Attack.adattack(warrior[i],player);
                    Attack.apattack(warrior[i],player);
                }
                break;

        }
    }

    @Override
    public void Meet() {

    }

    @Override
    public void Fight(Warrior warrior[]) {
        System.out.println("你选择了奋起反抗");
        int length = warrior.length;//人数
        int x = (int) Math.random()*length;//人数中随机一个
        for(int i =0;i< warrior.length;i++){
            Attack.adattack(player,warrior[i]);
            Attack.apattack(player,warrior[i]);
            warrior[i].judge(warrior[i],warrior[i]);
        }
        if(warrior[x].getHp()>0){
            System.out.println(player.getName()+"对"+warrior[x].getName()+"进行了补刀");
            Attack.adattack(player,warrior[x]);
            Attack.apattack(player,warrior[x]);
//            warrior[x].judge(warrior[x],warrior[x]);
        }
//        for(int i = 0 ;i< warrior.length;i++){
//
//        }

    }

    @Override
    public void Odds() {
        int x = (int)(Math.random()*3);
        switch(x){
            case 0://遇到敌人
                System.out.println("不知道是哪来的小兵给了你一刀");
                int y =(int)(Math.random()*3);
                switch(y){
                    case 0:
                        Attack.adattack(new MeleeMinion(),player);
                        break;
                    case 1:
                        Attack.apattack(new CasterMinion(),player);
                        break;
                    case 2:
                        Attack.apattack(new SiegeMinion(),player);
                        Attack.apattack(new SiegeMinion(),player);
                        break;
                }
                    break;
            case 1://捡到装备
                int Weapon = weapons.length;//武器数量
                int W = (int)(Math.random()*Weapon);
                weapons[W].setPlayer(player);
                System.out.println(Player.getInstance().getName()+"幸运捡到了一个装备");
                System.out.println("你装备了"+weapons[W].getName());
                break;
            case 2://捡到宝箱
                int z = (int)(Math.random()*3);
                        switch(z){
                            case 0:
                                System.out.println("在路上你收获到了一本武功密集");
                                int a = (int)(25+Math.random()*25);
                                int b = (int)(25+Math.random()*25);
                                int c = (int)(25+Math.random()*25);
                                int d = (int)(25+Math.random()*25);
                                int e = (int)(25+Math.random()*25);
                                Player.getInstance().setAd(a+Player.getInstance().getAd());
                                System.out.println("你的AD提高了："+a);
                                Player.getInstance().setAp(b+Player.getInstance().getAp());
                                System.out.println("你的AP提高了："+b);
                                Player.getInstance().setAddef(c+Player.getInstance().getAddef());
                                System.out.println("你的护甲提高了："+c);
                                Player.getInstance().setApdef(d+Player.getInstance().getApdef());
                                System.out.println("你的魔抗提高了："+d);
                                Player.getInstance().setHp(e+Player.getInstance().getHp());
                                System.out.println("你的血量提高了："+e);
                                break;
                            case 1:
                                System.out.println("你收到了来自神秘人的惠赠");
                                Player.getInstance().setLevel(Player.getLevel()+1);
                                System.out.println("你的等级提高了");
                                break;
                            case 2:
                                final int[] price = new int[1];
                                System.out.println("你看到了一个宝箱");
                                System.out.println("..............");
                                System.out.println("你走上前，企图开启宝箱");
                                Attack.adattack(new Warrior(){//匿名类
                                    {
                                        price[0] = (int)(250+Math.random()*750);
                                        setHp(1);
                                        setName("宝箱怪");
                                        setPrice(price[0]);
                                        setAd((int)(25+Math.random()+25));
                                        setAp((int)(50+Math.random()+50));
                                    }
                                },player);
                                System.out.println("宝箱怪逃走了，但它在逃跑途中掉下了一些财宝");
                                Player.getInstance().changeMoney(price[0]);
                                System.out.println("你收获了 "+price[0]+" 金币");
                                break;
                    }
            case 3://游戏结束
                System.out.println("你突然发现了程序的BUG");
                System.out.println("你对自身产生了怀疑");
                System.out.println("你不断思考着自身的意义");
                System.out.println("你看出了这不过是被设计出的游戏");
                System.out.println("不愿被操控的你提前结束了游戏");
                Player.getInstance().setHp(0);
                player.judge((player));
                break;
            case 4://生命之泉
                System.out.println(player.getName()+" 找到了生命之泉");
                System.out.println("*************");
                System.out.println(player.getName()+" 引用了生命之泉");
                System.out.println(player.getName()+" 自我感觉良好");
                Player.getInstance().setHp(originHp + 250);
                System.out.println(player.getName()+" 的生命恢复到了"+player.getHp());
                break;

        }
    }

    @Override
    public void recuirt() {

    }

    @Override
    public void go() {
        System.out.println(player.getName()+" 继续前进");
    }
    static int levelnum = 1;//记录升级次数
    public static void levelUp(){

        if(Player.getLevel()>levelnum){
            System.out.println("你得到了升级");
            System.out.println("你的属性有所提高");
            System.out.println("当前等级："+Player.getLevel());
            player.setHp(player.originHp*Player.getLevel());
            player.setAp(player.originAp*Player.getLevel());
            player.setApdef(player.originApdef*Player.getLevel());
            player.setAddef(player.originAddef*Player.getLevel());
            player.setAd(player.originAd*Player.getLevel());
            levelnum++;
        }
    }

    public void buy(){//购买装备
        for(int i=0;i<player.getWeapons().length;i++){
            System.out.println((i+1)+":"+player.getWeapons()[i].getName());
        }
        switch (in.nextInt()){
            case 1:
                System.out.println("购买成功");
                System.out.println("你装备了"+player.getWeapons()[0].getName());
                player.getWeapons()[0].setPlayer(player);
                break;
            case 2:
                System.out.println("购买成功");
                System.out.println("你装备了"+player.getWeapons()[1].getName());
                player.getWeapons()[1].setPlayer(player);
                break;
            case 3:
                System.out.println("购买成功");
                System.out.println("你装备了"+player.getWeapons()[2].getName());
                player.getWeapons()[2].setPlayer(player);
                break;
            case 4:
                System.out.println("购买成功");
                System.out.println("你装备了"+player.getWeapons()[3].getName());
                player.getWeapons()[3].setPlayer(player);
                break;
            case 5:
                System.out.println("购买成功");
                System.out.println("你装备了"+player.getWeapons()[4].getName());
                player.getWeapons()[4].setPlayer(player);
                break;
            case 6:
                System.out.println("购买成功");
                System.out.println("你装备了"+player.getWeapons()[5].getName());
                player.getWeapons()[5].setPlayer(player);
                break;
            default:
                System.out.println("由于"+getName()+" 的错误输入");
                System.out.println("商店老板带着鄙夷的眼神离开了");
                Player.getInstance().changeShop();
                break;
        }

    }
}
