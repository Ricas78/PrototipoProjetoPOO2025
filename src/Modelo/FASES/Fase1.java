package Modelo.FASES;

import Modelo.Hero;
import Modelo.ITEMS.*;
import Modelo.MOBS.*;

public class Fase1 extends Fase {

        @Override
        public void criarFase() {

                wallpaper = "grassGROUND.png";

                hero = new Hero("MainHero.png");
                hero.setPosicao(0, 1);
                addPersonagem(hero);

                wallHori(2, 0, 13, "arbustoWALL.png");
                wallHori(6, 2, 15, "arbustoWALL.png");
                wallHori(21, 0, 11, "arbustoWALL.png");
                wallHori(24, 2, 15, "arbustoWALL.png");
                wallHori(27, 0, 15, "arbustoWALL.png");

                wallVert(7, 19, 2, "arbustoWALL.png");
                wallVert(9, 21, 5, "arbustoWALL.png");
                wallVert(7, 19, 8, "arbustoWALL.png");
                wallVert(8, 20, 11, "arbustoWALL.png");
                wallVert(7, 23, 15, "arbustoWALL.png");

                Heart h1 = new Heart("heart.png");
                h1.setPosicao(1, 14);
                addPersonagem(h1);

                Heart h2 = new Heart("heart.png");
                h2.setPosicao(13, 1);
                addPersonagem(h2);

                Heart h3 = new Heart("heart.png");
                h3.setPosicao(20, 8);
                addPersonagem(h3);

                Key k1 = new Key("key.png");
                k1.setPosicao(1, 12);
                addPersonagem(k1);

                Key k2 = new Key("key.png");
                k2.setPosicao(4, 0);
                addPersonagem(k2);

                Key k3 = new Key("key.png");
                k3.setPosicao(7, 5);
                addPersonagem(k3);

                Key k4 = new Key("key.png");
                k4.setPosicao(22, 13);
                addPersonagem(k4);

                Key k5 = new Key("key.png");
                k5.setPosicao(25, 13);
                addPersonagem(k5);

                MobV b1 = new MobV("warriorSk.png", 1, 3,
                                true);
                b1.setPosicao(0, 7);
                addPersonagem(b1);

                MobV b2 = new MobV("warriorSk.png", 2, 3,
                                true);
                b2.setPosicao(5, 6);
                addPersonagem(b2);

                MobV b3 = new MobV("warriorSk.png", 2, 2,
                                true);
                b3.setPosicao(5, 10);
                addPersonagem(b3);

                MobV b4 = new MobV("warriorSk.png", 2, 2,
                                false);
                b4.setPosicao(3, 3);
                addPersonagem(b4);

                MobV b5 = new MobV("warriorSk.png", 1, 2,
                                false);
                b5.setPosicao(22, 9);
                addPersonagem(b5);

                MobV b6 = new MobV("warriorSk.png", 1, 2,
                                false);
                b6.setPosicao(22, 7);
                addPersonagem(b6);

                MobV b7 = new MobV("warriorSk.png", 1, 2,
                                true);
                b7.setPosicao(23, 5);
                addPersonagem(b7);

                MobV b8 = new MobV("warriorSk.png", 1, 2,
                                true);
                b8.setPosicao(26, 11);
                addPersonagem(b8);

                MobH bh1 = new MobH("slime.png", 1, 2,
                                true);
                bh1.setPosicao(9, 0);
                addPersonagem(bh1);

                MobH bh2 = new MobH("slime.png", 1, 2,
                                true);
                bh2.setPosicao(15, 1);
                addPersonagem(bh2);

                MobH bh3 = new MobH("slime.png", 1, 2,
                                false);
                bh3.setPosicao(18, 3);
                addPersonagem(bh3);

                MobH bh4 = new MobH("slime.png", 1, 2,
                                false);
                bh4.setPosicao(12, 3);
                addPersonagem(bh4);

                MobH bh5 = new MobH("slime.png", 1, 2,
                                false);
                bh5.setPosicao(15, 6);
                addPersonagem(bh5);

                MobH bh6 = new MobH("slime.png", 2, 2,
                                false);
                bh6.setPosicao(11, 12);
                addPersonagem(bh6);

                MobH bh7 = new MobH("slime.png", 2, 1,
                                false);
                bh7.setPosicao(13, 12);
                addPersonagem(bh7);

                MobH bh8 = new MobH("slime.png", 2, 2,
                                true);
                bh8.setPosicao(15, 14);
                addPersonagem(bh8);
        }
}
