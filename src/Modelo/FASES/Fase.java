package Modelo.FASES;

import java.io.Serializable;
import java.util.ArrayList;

import Modelo.Hero;
import Modelo.Personagem;
import Modelo.Wall;

public abstract class Fase implements Serializable {
    protected ArrayList<Personagem> personagens;
    protected Hero hero;
    protected String wallpaper;

    public Fase() {
        personagens = new ArrayList<>();
        criarFase(); // cada subclasse implementa isso
    }

    public abstract void criarFase();

    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }

    public Hero getHero() {
        return hero;
    }

    public String getWallpaper() {
        return wallpaper;
    }

    protected void addPersonagem(Personagem p) {
        personagens.add(p);
    }

    public void wallHori(int l, int ci, int cf, String im) {

        Wall[] a = new Wall[cf - ci + 1];

        for (int i = 0; i < (cf - ci + 1); i++) {
            a[i] = new Wall(im);
            a[i].setPosicao(l, ci + i);
            this.addPersonagem(a[i]);
        }
    }

    public void wallVert(int li, int lf, int c, String im) {

        Wall[] a = new Wall[lf - li + 1];

        for (int i = 0; i < (lf - li + 1); i++) {
            a[i] = new Wall(im);
            a[i].setPosicao(li + i, c);
            this.addPersonagem(a[i]);
        }
    }
}
