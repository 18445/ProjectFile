package com.MOBA;
//小兵
public class Warrior extends Actor implements Attack,IsAlive{

    public void setPrice(int price) {
        this.price = price;
    }
    private Player player;
    private int price;//小兵价格
    public Warrior(String name, int hp, int ad, int addef, int ap, int apdef) {
        super(name, hp, ad, addef, ap, apdef);
    }
    public Warrior(){
        super();
    }
    public int getPrice() {
        return price;
    }
    //接口回调
    @Override
    public void isAlive() {
        System.out.println("小兵被击杀");
    }

    public Warrior(String name, double hp, int ad, int addef, int ap, int apdef, Player player) {
        super(name, hp, ad, addef, ap, apdef);
        this.player = player;
    }

    //判断角色是否被击杀 isAlive(被重写方法) actor(主角生命值) 传入两个？
    public void judge(IsAlive isAlive,Actor actor){
        if(actor.getHp()<0){
            isAlive.isAlive();
        }else{
            System.out.println("角色存活");
        }
    }

    //传入英雄
    public void setPlayer(Player player){
        this.player = player;
    }
    //判断小兵是否存活
    public void judge(Actor actor){
        player.judge(this,actor);
    }

    @Override
    public void beAttack() {

    }

    public static Warrior[] combine(Warrior warrior1[],Warrior warrior2[]){
        int enemy1 = warrior1.length + warrior2.length;
        Warrior warrior[] = new Warrior[enemy1];
        for (int i = 0;i < enemy1;i++){
            if(i< warrior1.length){
                warrior [i] = warrior1[i];
                continue;
            }
            warrior[i] = warrior2[i- warrior1.length];
        }
        return warrior;
    }

    public static boolean stillAlive(Warrior warrior[]){//判断是否有小兵存活
        if(warrior == null){ return false;}
        for (int i = 0;i< warrior.length&&warrior[i]!=null;i++){
            if(warrior[i].getHp() > 0){
                return true;
            }
        }
        return false;
    }
    public static Warrior[] returnAlive(Warrior warrior[]){//返回还存活的小兵
        int x = 0;
        if(!stillAlive(warrior)){return null;}
        for (int i = 0;i< warrior.length;i++){//记录存活输
            if(warrior[i].getHp()>0){
                x++;
            }
        }
        Warrior warriornew[] = new Warrior[x];
        int y = 0;
        for(int i =0;i<x;i++){//返回生命值大于0的小兵
            if(warrior[i].getHp()>0){
                warriornew [y++] = warrior[i];
            }
        }
        return warriornew;
    }
    public static void attack(Warrior warrior[]){//攻击
        for(int i =0;i< warrior.length&&warrior[i]!=null;i++){
            Attack.adattack(warrior[i],Player.getInstance() );
            Attack.apattack(warrior[i],Player.getInstance() );
        }
    }
}


//近战兵
class MeleeMinion extends Warrior{
    static int i =0;//静态变量表示编号
    public MeleeMinion(String name, int hp, int ad, int addef, int ap, int apdef) {
        super(name, hp, ad, addef, ap, apdef);
    }
    public MeleeMinion(){

    }
    //随机设置小兵属性
    {
        setPrice((int) (25+Math.random()*25)*Player.getLevel() );
        setAd((int) (20+Math.random()*20)*Player.getLevel() );
        setName("近战兵"+ ++i);
        setApdef((int) (20+Math.random()*20)*Player.getLevel()  );
        setAddef((int) (20+Math.random()*20) *Player.getLevel() );
        setHp((int) (25+Math.random()*25)*Player.getLevel()  );
    }

}
//远程兵
class CasterMinion extends Warrior{
    static int i =1;
    public CasterMinion(String name, int hp, int ad, int addef, int ap, int apdef) {
        super(name, hp, ad, addef, ap, apdef);
    }
    public CasterMinion(){

    }
    {
        setPrice((int) (15+Math.random()*25)*Player.getLevel()  );
        setAp((int) (20+Math.random()*20)*Player.getLevel()  );
        setName("远程兵"+i++);
        setApdef((int) (10+Math.random()*10) *Player.getLevel() );
        setAddef((int) (10+Math.random()*10)*Player.getLevel()  );
        setHp((int) (20+Math.random()*20)*Player.getLevel()  );

    }
}
//跑车
class SiegeMinion extends Warrior{
    static int i = 1;
    public SiegeMinion(String name, int hp, int ad, int addef, int ap, int apdef) {
        super(name, hp, ad, addef, ap, apdef);
    }
    public SiegeMinion(){

    }
    {   setName("跑车"+i++);
        setPrice((int) (100+Math.random()*100)*Player.getLevel()  );
        setAp((int) (50+Math.random()*50)*Player.getLevel()  );
        setAd((int) (50+Math.random()*50) *Player.getLevel() );
        setApdef((int) (30+Math.random()*15) *Player.getLevel() );
        setAddef((int) (30+Math.random()*15)*Player.getLevel()  );
        setHp((int) (50+Math.random()*50) *Player.getLevel() );
    }

}
//超级兵
class  SuperMinion extends Warrior{
    static int i =1;
    public SuperMinion(){

    }
    public SuperMinion(String name, int hp, int ad, int addef, int ap, int apdef) {
        super(name, hp, ad, addef, ap, apdef);
    }
    {

        setName("超级兵"+ i++);
        setPrice((int) (200+Math.random()*100)*Player.getLevel()  );
        setAd((int) (150+Math.random()*150)*Player.getLevel()  );
        setAp((int) (100+Math.random()*100) *Player.getLevel() );
        setApdef((int) (50+Math.random()*25)*Player.getLevel()  );
        setAddef((int) (50+Math.random()*25) *Player.getLevel() );
        setHp((int) (200+Math.random()*100)*Player.getLevel()  );

    }
}
//神秘人
class unknow extends Warrior{
    private static void Warrior(){

    }
    {
        setName("Unkonw");
        setAd(2021214171);
        setApdef(20214171);
        setAddef(2021214171);
        setHp(2021214171);
        setAp(2021214171);
    }
    static unknow UN = new unknow();

    public static unknow getInstance(){
        return UN;
    }






}

