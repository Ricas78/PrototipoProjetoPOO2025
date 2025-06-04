package Modelo.FASES;

import Modelo.Hero;
import Modelo.ITEMS.*;
import Modelo.MOBS.*;

public class Fase3 extends Fase {

        public void criarFase() {

                wallpaper = "dungeon.png";

                hero = new Hero("MainHero.png");
                hero.setPosicao(0, 0);
                addPersonagem(hero);

                wallHori(2, 0, 0, "dg.png");
                wallHori(0, 3, 15, "dg.png");
                wallHori(21, 0, 12, "dg.png");
                wallHori(24, 2, 15, "dg.png");
                wallHori(27, 0, 13, "dg.png");

                wallVert(1, 19, 3, "dgv.png");
                wallVert(2, 20, 6, "dgv.png");
                wallVert(1, 19, 9, "dgv.png");
                wallVert(2, 20, 12, "dgv.png");
                wallVert(1, 23, 15, "dgv.png");

                Key k1 = new Key("key.png");
                k1.setPosicao(20, 3);
                addPersonagem(k1);

                Key k2 = new Key("key.png");
                k2.setPosicao(20, 9);
                addPersonagem(k2);

                Key k3 = new Key("key.png");
                k3.setPosicao(23, 8);
                addPersonagem(k3);

                Key k4 = new Key("key.png");
                k4.setPosicao(26, 5);
                addPersonagem(k4);

                Key k5 = new Key("key.png");
                k5.setPosicao(28, 0);
                addPersonagem(k5);

                Heart h1 = new Heart("heart.png");
                h1.setPosicao(2, 4);
                addPersonagem(h1);

                Heart h2 = new Heart("heart.png");
                h2.setPosicao(1, 12);
                addPersonagem(h2);

                Heart h3 = new Heart("heart.png");
                h3.setPosicao(25, 2);
                addPersonagem(h3);

                Wizzard z = new Wizzard("WizzardSk.png", 3, 3);
                z.setPosicao(4, 5);
                addPersonagem(z);

                Wizzard z2 = new Wizzard("WizzardSk.png", 3, 3);
                z2.setPosicao(8, 11);
                addPersonagem(z2);

                Wizzard z3 = new Wizzard("WizzardSk.png", 1, 3);
                z3.setPosicao(23, 1);
                addPersonagem(z3);

                Arrow a1 = new Arrow("arrow.png", 0, 10,
                                true, true);
                a1.setPosicao(23, 13);
                addPersonagem(a1);

                Arrow a2 = new Arrow("arrow.png", 1, 10,
                                true, true);
                a2.setPosicao(20, 0);
                addPersonagem(a2);

                Arrow a3 = new Arrow("arrow.png", 0, 10,
                                true, true);
                a3.setPosicao(20, 7);
                addPersonagem(a3);

                MobV b1 = new MobV("warriorSk.png", 1, 3,
                                false);
                b1.setPosicao(22, 7);
                addPersonagem(b1);

                MobV b2 = new MobV("warriorSk.png", 1, 3,
                                true);
                b2.setPosicao(23, 9);
                addPersonagem(b2);

                MobV b3 = new MobV("warriorSk.png", 1, 3,
                                true);
                b3.setPosicao(26, 4);
                addPersonagem(b3);

                MobV b4 = new MobV("warriorSk.png", 1, 3,
                                false);
                b4.setPosicao(25, 6);
                addPersonagem(b4);

                MobV b5 = new MobV("warriorSk.png", 1, 5,
                                false);
                b5.setPosicao(28, 2);
                addPersonagem(b5);

                MobV b6 = new MobV("warriorSk.png", 1, 4,
                                true);
                b6.setPosicao(29, 3);
                addPersonagem(b6);

                MobV b7 = new MobV("warriorSk.png", 1, 5,
                                false);
                b7.setPosicao(28, 4);
                addPersonagem(b7);

        }
}
