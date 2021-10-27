package com.Level0;

public class Test {
    public static void main(String[] args) {
        Refrigerator r = new Refrigerator();
        WashingMachine W = new WashingMachine();
        Oven O = new Oven();
        Elephant E = new Elephant();
        Tigers T = new Tigers();
        Monkey M = new Monkey();
        Wardrobe Wa = new Wardrobe();
        E.enter(r);
        E.enter(W);
        E.enter(O);
        E.enter(Wa);
        T.enter(r);
        T.enter(Wa);
        M.enter(O);
        O.dry(E);
        W.Wash(T);

    }
}
