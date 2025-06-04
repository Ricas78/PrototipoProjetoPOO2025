package Modelo;

public class Fase0 extends Fase {
        @Override
        protected void criarFase() {

                wallpaper = "grassGROUND.png";

                hero = new Hero("MainHero.png");
                hero.setPosicao(0, 1);
                addPersonagem(hero);

                wallHori(2, 0, 8, "arbustoWALL.png");
                wallHori(8, 0, 1, "arbustoWALL.png");
                wallHori(24, 14, 15, "arbustoWALL.png");
                wallHori(19, 0, 1, "arbustoWALL.png");

                wallVert(0, 5, 11, "arbustoWALL.png");
                wallVert(3, 5, 8, "arbustoWALL.png");
                wallVert(8, 16, 2, "arbustoWALL.png");
                wallVert(12, 21, 13, "arbustoWALL.png");
                wallVert(24, 28, 13, "arbustoWALL.png");
                wallVert(19, 24, 2, "arbustoWALL.png");

                Key k1 = new Key("key.png");
                k1.setPosicao(0, 12);
                addPersonagem(k1);

                Key k2 = new Key("key.png");
                k2.setPosicao(9, 1);
                addPersonagem(k2);

                Key k3 = new Key("key.png");
                k3.setPosicao(17, 15);
                addPersonagem(k3);

                Key k4 = new Key("key.png");
                k4.setPosicao(21, 1);
                addPersonagem(k4);

                Key k5 = new Key("key.png");
                k5.setPosicao(25, 14);
                addPersonagem(k5);

                Heart h1 = new Heart("heart.png");
                h1.setPosicao(3, 3);
                addPersonagem(h1);

                Heart h2 = new Heart("heart.png");
                h2.setPosicao(15, 8);
                addPersonagem(h2);

                Heart h3 = new Heart("heart.png");
                h3.setPosicao(29, 1);
                addPersonagem(h3);

                MobHorizontal b1 = new MobHorizontal("slime.png", 7, 3,
                                false);
                b1.setPosicao(4, 0);
                addPersonagem(b1);

                MobHorizontal b2 = new MobHorizontal("slime.png", 3, 2,
                                true);
                b2.setPosicao(6, 7);
                addPersonagem(b2);

                MobHorizontal b3 = new MobHorizontal("slime.png", 3, 2,
                                false);
                b3.setPosicao(2, 12);
                addPersonagem(b3);

                MobHorizontal b4 = new MobHorizontal("slime.png", 3, 2,
                                true);
                b4.setPosicao(4, 15);
                addPersonagem(b4);

                MobHorizontal b5 = new MobHorizontal("slime.png", 7, 2,
                                false);
                b5.setPosicao(8, 8);
                addPersonagem(b5);

                MobHorizontal b6 = new MobHorizontal("slime.png", 5, 1,
                                false);
                b6.setPosicao(10, 10);
                addPersonagem(b6);

                MobHorizontal b7 = new MobHorizontal("slime.png", 9, 1,
                                false);
                b7.setPosicao(13, 3);
                addPersonagem(b7);

                MobHorizontal b8 = new MobHorizontal("slime.png", 9, 1,
                                true);
                b8.setPosicao(16, 12);
                addPersonagem(b8);

                MobHorizontal b9 = new MobHorizontal("slime.png", 5, 1,
                                false);
                b9.setPosicao(20, 3);
                addPersonagem(b9);

                MobHorizontal b10 = new MobHorizontal("slime.png", 5,
                                1,
                                true);
                b10.setPosicao(21, 12);
                addPersonagem(b10);

                // Chaser chaser = new Chaser("ChaserBear.png", 4);
                // chaser.setPosicao(0, 0);
                // addPersonagem(chaser);
        }
}
