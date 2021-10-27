package com.MOBA;
//创建小兵数量
public class Build {//创建角色
    public static MeleeMinion[] buildMelee(int x,int y ){
        //近战兵 随机生成X-Y
        try {//异常处理（传入数据可能有误）
            int z = (int)(x+Math.random()*(y-x));
            MeleeMinion meleeMiniongroup[] = new MeleeMinion[z];
            for(int i =0;i < z;i++ ){
                meleeMiniongroup[i] = new MeleeMinion();

            }
            return meleeMiniongroup;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("异常");
        return null;
    }
    public static CasterMinion[] buildCaster(int x,int y ){
        //远程兵 随机生成X-Y
        try {//异常处理（传入数据可能有误）
            int z = (int)(x+Math.random()*(y-x));
            CasterMinion casterMiniongourp[] = new CasterMinion[z];
            for(int i =0;i < z;i++ ){
                casterMiniongourp[i] = new CasterMinion();

            }
            return casterMiniongourp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("异常");
        return null;
    }
    public static SiegeMinion[] buildSiege(int x,int y ){
        //跑车 随机生成X-Y
        try {//异常处理（传入数据可能有误）
            int z = (int)(x+Math.random()*(y-x));
            SiegeMinion SiegeMiniongourp[] = new SiegeMinion[z];
            for(int i =0;i < z;i++ ){
                SiegeMiniongourp[i] = new SiegeMinion();

            }
            return SiegeMiniongourp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("异常");
        return null;
    }
    public static SuperMinion[] buildSuper(int x,int y ){
        //超级兵 随机生成X-Y
        try {//异常处理（传入数据可能有误）
            int z = (int)(x+Math.random()*(y-x));
            SuperMinion SuperMiniongourp[] = new SuperMinion[z];
            for(int i =0;i < z;i++ ){
                SuperMiniongourp[i] = new SuperMinion();

            }
            return SuperMiniongourp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("异常");
        return null;
    }

}
