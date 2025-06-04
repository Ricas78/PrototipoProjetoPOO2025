package Modelo;

public class Fase4 extends Fase {

    protected void criarFase() {

        wallpaper = "dungeon.png";

        hero = new Hero("MainHero.png");
        hero.setPosicao(1, 8);
        addPersonagem(hero);

        wallHori(2, 0, 13, "dg.png");
        wallHori(5, 3, 5, "dg.png");
        wallHori(5, 8, 15, "dg.png");
        wallHori(10, 0, 1, "dg.png");
        wallHori(13, 13, 15, "dg.png");
        wallHori(8, 6, 7, "dg.png");
        wallHori(14, 0, 1, "dg.png");
        wallHori(16, 3, 12, "dg.png");
        wallHori(27, 0, 13, "dg.png");
        wallHori(16, 15, 15, "dg.png");

        wallVert(4, 10, 2, "dgv.png");
        wallVert(6, 11, 13, "dgv.png");
        wallVert(12, 14, 2, "dgv.png");
        wallVert(17, 24, 3, "dgv.png");
        wallVert(18, 26, 7, "dgv.png");
        wallVert(17, 25, 9, "dgv.png");
        wallVert(18, 26, 13, "dgv.png");
        wallVert(14, 16, 13, "dgv.png");

        Heart h1 = new Heart("heart.png");
        h1.setPosicao(4, 15);
        addPersonagem(h1);

        Heart h2 = new Heart("heart.png");
        h2.setPosicao(13, 1);
        addPersonagem(h2);

        Heart h3 = new Heart("heart.png");
        h3.setPosicao(26, 9);
        addPersonagem(h3);

        Key k1 = new Key("key.png");
        k1.setPosicao(9, 1);
        addPersonagem(k1);

        Key k2 = new Key("key.png");
        k2.setPosicao(6, 15);
        addPersonagem(k2);

        Key k3 = new Key("key.png");
        k3.setPosicao(17, 7);
        addPersonagem(k3);

        Key k4 = new Key("key.png");
        k4.setPosicao(14, 15);
        addPersonagem(k4);

        Key k5 = new Key("key.png");
        k5.setPosicao(28, 0);
        addPersonagem(k5);

        Chaser chaser = new Chaser("ghost.png", 7);
        chaser.setPosicao(1, 0);
        addPersonagem(chaser);

        ZigueZague z = new ZigueZague("WizzardSk.png", 2, 5);
        z.setPosicao(19, 12);
        addPersonagem(z);

        ZigueZague z2 = new ZigueZague("WizzardSk.png", 2, 5);
        z2.setPosicao(20, 6);
        addPersonagem(z2);

        ZigueZague z3 = new ZigueZague("WizzardSk.png", 2, 5);
        z3.setPosicao(18, 2);
        addPersonagem(z3);

        ZigueZague z4 = new ZigueZague("WizzardSk.png", 3, 5);
        z4.setPosicao(6, 3);
        addPersonagem(z4);

        ArrowSK a1 = new ArrowSK("arrow.png", 2, 8,
                true, true);
        a1.setPosicao(15, 12);
        addPersonagem(a1);

        ArrowSK a2 = new ArrowSK("arrow.png", 2, 7,
                false, true);
        a2.setPosicao(15, 7);
        addPersonagem(a2);

        ArrowSK a3 = new ArrowSK("arrow.png", 2, 8,
                true, true);
        a3.setPosicao(15, 6);
        addPersonagem(a3);

        ArrowSK a4 = new ArrowSK("arrow.png", 0, 12,
                true, false);
        a4.setPosicao(6, 14);
        addPersonagem(a4);

        ArrowSK a5 = new ArrowSK("arrow.png", 0, 12,
                true, true);
        a5.setPosicao(29, 15);
        addPersonagem(a5);

        MobVertical b1 = new MobVertical("warriorSk.png", 1, 3,
                true);
        b1.setPosicao(1, 9);
        addPersonagem(b1);

        MobVertical b2 = new MobVertical("warriorSk.png", 1, 3,
                false);
        b2.setPosicao(3, 8);
        addPersonagem(b2);

        MobVertical b3 = new MobVertical("warriorSk.png", 1, 3,
                false);
        b3.setPosicao(28, 10);
        addPersonagem(b3);

        MobVertical b4 = new MobVertical("warriorSk.png", 1, 3,
                true);
        b4.setPosicao(29, 7);
        addPersonagem(b4);

        MobVertical b5 = new MobVertical("warriorSk.png", 1, 3,
                false);
        b5.setPosicao(29, 2);
        addPersonagem(b5);

    }
}
