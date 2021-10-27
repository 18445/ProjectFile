package com.MOBA;

interface Attack {
    //伤害计算 1攻击2
     static void adattack(Actor actor1,Actor actor2){
        int damage =actor1.getAd() * (int)((100.0 / ((actor2.getAddef()-actor1.getAddefValue())*(100-actor1.getAddefPer())))+1);
        System.out.println(actor1.getName()+"对"+actor2.getName()+"造成了 "+damage+" AD伤害");
//        if(actor2.getHp()<=0){
//            System.out.println(actor2.getName()+"已死亡");
//        }
        if(actor2 instanceof Player){
         Player.getInstance().ChangeHp(-damage);
         System.out.println("角色剩余血量："+Player.getInstance().getHp());
        }
         if(actor2 instanceof Warrior){
             actor2.setHp(actor2.getHp()-damage);
             System.out.println(actor2.getName()+"剩余血量："+actor2.getHp());
             Player.getInstance().judge(actor2);
         }
    }
     static void apattack(Actor actor1,Actor actor2){
        int damage =actor1.getAp() * (int)((100.0 / ((actor2.getApdef()-actor1.getApdefValue())*(100-actor1.getApdefPer())))+1);
        System.out.println(actor1.getName()+"对"+actor2.getName()+"造成了 "+damage+" Ap伤害");
//        if(actor2.getHp()<=0){
//            System.out.println(actor2.getName()+"已死亡");
//        }
         if(actor2 instanceof Player){
         Player.getInstance().ChangeHp(-(int)(damage+0.5));
         System.out.println("角色剩余血量："+Player.getInstance().getHp());
         }
         if(actor2 instanceof Warrior){
             actor2.setHp(actor2.getHp()-damage);
             System.out.println(actor2.getName()+"剩余血量："+actor2.getHp());
             Player.getInstance().judge(actor2);
         }
    }

    void beAttack();
}
