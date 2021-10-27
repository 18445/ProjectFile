package com.MOBA;

import java.util.Scanner;

import static com.MOBA.Build.*;

public class Test {
    public static void main(String[] args) {
        Player.getInstance();
        Player.getInstance().setWeapons( View.getWeapon() );//角色获得装备栏
        Player player = Player.getPlayer();//将实例化的角色传给player
        List.playerView(player);
        boolean ifBattle = false;//是否战斗
//        List.playerView(Player.getInstance());
//        View.weapon( player.getWeapons() );//遍历装备
//        System.out.println(player.getHp());
        //创建敌人
        MeleeMinion meleeMinion1[] = Build.buildMelee(2,4);
//        List.playerView( meleeMinion1[1] );
        Thread one = new oneThread(meleeMinion1);//攻击
        CasterMinion casterMinion1[] = Build.buildCaster(2,4);
        Thread two = new oneThread(casterMinion1);
        one.start();
        two.start();
        Warrior warrior1[] = Warrior.combine(meleeMinion1,casterMinion1);

    //Level 1
        Scanner in = new Scanner(System.in);
        boolean hasChoice = true;
        boolean end=true;
        int choice ;
       while(end){
           if(!one.isAlive() && !two.isAlive()){//线程执行完
            player.beAttack();
            end = false;
            System.out.println("你的选择是：");
            System.out.println("1：奋起反抗！");
            System.out.println("2：崩扯卖溜！");
        do{//选择
            choice = in.nextInt();
            switch(choice){
                case 1:
                    ifBattle =true;
                    while(Warrior.stillAlive(warrior1))
                    {
                    player.Fight(warrior1);
                    warrior1 = Warrior.returnAlive(warrior1);
                    if( warrior1 != null&&Warrior.stillAlive(warrior1) ){//有存活——反击
                        Warrior.attack(warrior1);
                        List.playerView(warrior1);
                    }
                    }
                    hasChoice = false;
                    break;
                case 2:
                    player.Escape(warrior1);
                    hasChoice = false;
                    break;
                default:
                    System.out.println("输入有误");
            }

        }while(hasChoice);
       }
    }

        System.out.println("\n\n");
        if(ifBattle){//是否战斗
        System.out.println("经过这场战斗，你升级了");
        player.changLevel((Player.getLevel()+1));
        Player.levelUp();
         }
        //Level 2

        System.out.println("\n\n");
        System.out.println("你存活了下来，你看了看自身的状态:");
        List.playerView(player);
        System.out.println("\n\n");
        System.out.println("接下来你准备：");
        System.out.println("1：到处逛逛");
        System.out.println("2：继续前进");
        System.out.println("*********");
        int choice2;
        hasChoice = true;
        do{
            choice2 = in.nextInt();
            switch (choice2){
                case 1:
                    player.Odds();
                    hasChoice = false;
                    break;
                case 2:
                    player.go();
                    hasChoice = false;
                    break;
                default:
                    System.out.println("输入有误");
            }
        }while(hasChoice);

        ifBattle = false ;
        SiegeMinion siegeMinion2[] = Build.buildSiege(1,2);
        MeleeMinion meleeMinion2[] = Build.buildMelee(3,5);
        CasterMinion casterMinion2[] = Build.buildCaster(3,5);
        Warrior temp[] = Warrior.combine(siegeMinion2,meleeMinion2);
        Warrior Level2Warrior[] =Warrior.combine(temp,casterMinion2);
        Thread three = new oneThread(siegeMinion2);
        Thread four = new oneThread(meleeMinion2);
        Thread five = new oneThread(casterMinion2);
        three.start();
        four.start();
        five.start();
        boolean hasChoice2 = true;
        boolean end2=true;
        int choice3 ;
        while(end2){
            if(!three.isAlive() && !four.isAlive()&&!five.isAlive()){//线程执行完
                player.beAttack();
                end2 = false;
                System.out.println("你的选择是：");
                System.out.println("1：奋起反抗！");
                System.out.println("2：崩扯卖溜！");
                do{//选择
                    choice3 = in.nextInt();
                    switch(choice3){
                        case 1:
                            ifBattle =true;
                            while(Warrior.stillAlive(Level2Warrior))
                            {
                                player.Fight(Level2Warrior);
                                Level2Warrior = Warrior.returnAlive(Level2Warrior);
                                if( Level2Warrior!=null&&Warrior.stillAlive(Level2Warrior) ){//有存活——反击
                                    Warrior.attack(Level2Warrior);
                                    List.playerView(Level2Warrior);
                                }
                            }
                            hasChoice2 = false;
                            break;
                        case 2:
                            player.Escape(Level2Warrior);
                            hasChoice2 = false;
                            break;
                        default:
                            System.out.println("输入有误");
                    }

                }while(hasChoice2);
            }
        }
        System.out.println("\n\n");
        if (ifBattle){
        System.out.println("经过了这场战斗，你感觉有所提升");
        System.out.println("你的等级得到了提升");
        player.changLevel((Player.getLevel()+2));
        Player.levelUp();
        }
        System.out.println("接下来你准备：");
        System.out.println("1：到处逛逛");
        System.out.println("2：继续前进");
        System.out.println("*********");
        int choice4;
        hasChoice = true;
        do{
            choice4 = in.nextInt();
            switch (choice4){
                case 1:
                    player.Odds();
                    hasChoice = false;
                    break;
                case 2:
                    player.go();
                    hasChoice = false;
                    break;
                default:
                    System.out.println("输入有误");
            }
        }while(hasChoice);
        System.out.println("\n");
        System.out.println("你走在通往胜利的路上");
        System.out.println("这时你遇到了过路的商店老板");
        System.out.println("商店老板给你看了下他的包裹：");
        View.weapon( player.getWeapons() );//遍历装备
        if(Player.getInstance().shop){
            System.out.println("由于 "+player.getName()+" 收到了商店老板的鄙视");
            System.out.println("商店老板不准备卖给你东西");
            System.out.println("商店老板鄙夷的看了你一眼而离去");
        }else{
            System.out.println("商店老板让你挑了一下武器：");
            System.out.println("你选择:");
            System.out.println("1：购买武器");
            System.out.println("2： 离开 ");
            System.out.println("0：试图抢夺");
            switch (in.nextInt()){
                case 1:
                    player.buy();
                    break;
                case 2:
                    System.out.println(player.getName()+" 离开了");
                    System.out.println("商店老板认为你看不起他的装备");
                    System.out.println("他决定以后都不会卖给你装备了");
                    player.changeShop();
                    break;
                case 0:
                    System.out.println(player.getName()+"试图攻击商店老板");
                    System.out.println("正当你准备出手时，一个神秘人出现");
                    System.out.println(player.getName()+" 来不及躲避，被神秘人当场拿下");
                    Attack.adattack(unknow.getInstance(),player);
                    player.judge((player));
                    break;
                default:
                    System.out.println(player.getName()+":歪比歪比？歪比巴卜？");
                    System.out.println("商店老板：？？");
                    System.out.println("商店老板缓缓打出问号并离去");
                    System.out.println("你收到了来自商店老板的鄙夷");
                    player.changeShop();
                    break;
            }
        }

        //最后一关
        System.out.println("\n\n");
        player.go();
        SuperMinion finalsuper[] = buildSuper(1,1);
        SiegeMinion finalsiege[] = buildSiege(2,2);
        MeleeMinion finalmelle[] = buildMelee(4,6);
        CasterMinion finalCaster[] = buildCaster(4,6);
        Warrior finaltemp1[] = Warrior.combine(finalsuper,finalsiege);
        Warrior finaltemp2[] = Warrior.combine(finalmelle,finalCaster);
        Warrior finalGroup[] = Warrior.combine(finaltemp1,finaltemp2);//整合小兵
        Thread finalTest = new oneThread(finalGroup);
        finalTest.start();
        boolean finalChoice = true;
        int finalx ;

                while(finalChoice){
                    if(!finalTest.isAlive()){
                player.beAttack();
                finalChoice = false;
                System.out.println("你的选择是：");
                System.out.println("1：奋起反抗！");
                System.out.println("2：崩扯卖溜！");
                do{//选择
                    finalx = in.nextInt();
                    switch(finalx){
                        case 1:
                            while(Warrior.stillAlive(finalGroup))
                            {
                                player.Fight(finalGroup);
                                finalGroup = Warrior.returnAlive(finalGroup);
                                if( finalGroup!=null&&Warrior.stillAlive(finalGroup) ){//有存活——反击
                                    Warrior.attack(finalGroup);
                                    List.playerView(finalGroup);
                                }
                            }
                            finalChoice = false;
                            break;
                        case 2:
                            player.Escape();
                        default:
                            System.out.println("输入有误");
                    }

                }while(finalChoice);
            }
        }
        System.out.println("\n\n");
        System.out.println(player.getName()+" 获得了胜利");
        System.out.println(player.getName()+" 回头看了看满目的尸体与手上的鲜血");
        System.out.println(player.getName()+" 又仿佛什么都没有得到");
        System.out.println(player.getName()+" 不禁问自己：");
        System.out.println("这一切都值得吗？");
        System.out.println("");
        System.out.println("The end");
        System.out.println("--------------------------------------------");
    }//结束
}
//多线程(随机攻击)
class oneThread extends Thread {
    private Warrior warrior[];
    public oneThread(Warrior warrior[]){
        this.warrior = warrior;
    }
    public void run(){
        int x = warrior.length;//传入数组长度
        int y = (int)(1+Math.random()*(x - 1));//随机y个小兵
        for(int i =0;i<x;i++){
            Actor actor = warrior[i];
            Attack.adattack(actor,Player.getInstance());
            Attack.apattack(actor,Player.getInstance());
            warrior[i].judge(Player.getInstance(),Player.getInstance());
        }
    }
}
