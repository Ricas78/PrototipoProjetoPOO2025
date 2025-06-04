package Modelo.FASES;

import Modelo.Hero;
import Modelo.ITEMS.*;
import Modelo.MOBS.*;

public class Fase2 extends Fase {

        public void criarFase() {

                wallpaper = "ruins.png";

                hero = new Hero("MainHero.png");
                hero.setPosicao(0, 1);
                addPersonagem(hero);

                wallHori(2, 0, 1, "rocks.png");
                wallHori(4, 5, 10, "rocks.png");
                wallHori(1, 15, 15, "rocks.png");
                wallHori(8, 0, 1, "rocks.png");
                wallHori(13, 14, 15, "rocks.png");
                wallHori(10, 7, 8, "rocks.png");
                wallHori(17, 0, 4, "rocks.png");
                wallHori(14, 5, 6, "rocks.png");
                wallHori(14, 9, 10, "rocks.png");
                wallHori(17, 11, 15, "rocks.png");
                wallHori(26, 4, 15, "rocks.png");

                wallVert(8, 15, 1, "rocks.png");
                wallVert(9, 13, 13, "rocks.png");

                Key k1 = new Key("key.png");
                k1.setPosicao(0, 15);
                addPersonagem(k1);

                Key k2 = new Key("key.png");
                k2.setPosicao(12, 14);
                addPersonagem(k2);

                Key k3 = new Key("key.png");
                k3.setPosicao(9, 0);
                addPersonagem(k3);

                Key k4 = new Key("key.png");
                k4.setPosicao(25, 15);
                addPersonagem(k4);

                Key k5 = new Key("key.png");
                k5.setPosicao(28, 15);
                addPersonagem(k5);

                Heart h1 = new Heart("heart.png");
                h1.setPosicao(7, 0);
                addPersonagem(h1);

                Heart h2 = new Heart("heart.png");
                h2.setPosicao(16, 15);
                addPersonagem(h2);

                Heart h3 = new Heart("heart.png");
                h3.setPosicao(26, 1);
                addPersonagem(h3);

                Arrow a1 = new Arrow("arrow.png", 2, 5,
                                true, true);
                a1.setPosicao(13, 6);
                addPersonagem(a1);

                Arrow a2 = new Arrow("arrow.png", 1, 8,
                                false, true);
                a2.setPosicao(10, 2);
                addPersonagem(a2);

                Arrow a3 = new Arrow("arrow.png", 2, 5,
                                false, true);
                a3.setPosicao(13, 9);
                addPersonagem(a3);

                Arrow a4 = new Arrow("arrow.png", 3, 7,
                                false, true);
                a4.setPosicao(8, 12);
                addPersonagem(a4);

                Arrow a5 = new Arrow("arrow.png", 2, 7,
                                true, true);
                a5.setPosicao(25, 10);
                addPersonagem(a5);

                Arrow a6 = new Arrow("arrow.png", 2, 7,
                                false, true);
                a6.setPosicao(25, 5);
                addPersonagem(a6);

                Arrow a7 = new Arrow("arrow.png", 4, 4,
                                false, true);
                a7.setPosicao(23, 0);
                addPersonagem(a7);

                Arrow a8 = new Arrow("arrow.png", 4, 4,
                                true, true);
                a8.setPosicao(23, 15);
                addPersonagem(a8);

                MobV b1 = new MobV("warriorSk.png", 2, 3,
                                false);
                b1.setPosicao(27, 11);
                addPersonagem(b1);

                MobV b2 = new MobV("warriorSk.png", 2, 1,
                                true);
                b2.setPosicao(29, 9);
                addPersonagem(b2);

                MobV b3 = new MobV("warriorSk.png", 3, 2,
                                true);
                b3.setPosicao(3, 5);
                addPersonagem(b3);

                MobV b4 = new MobV("warriorSk.png", 3, 2,
                                false);
                b4.setPosicao(0, 10);
                addPersonagem(b4);
        }
}
