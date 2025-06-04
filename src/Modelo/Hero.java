package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;
import Modelo.ITEMS.Item;

public class Hero extends Personagem {

    private int chave;
    private int vida;
    private final int VIDA_MAXIMA = 3;

    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.vida = VIDA_MAXIMA;
        this.chave = 0;
        bMortal = true;
    }

    public void voltaAUltimaPosicao() {
        this.pPosicao.volta();
    }

    public boolean setPosicao(int linha, int coluna) {
        if (this.pPosicao.setPosicao(linha, coluna)) {
            if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
                this.voltaAUltimaPosicao();
            }
            return true;
        }
        return false;
    }

    /*
     * TO-DO: este metodo pode ser interessante a todos os personagens que se movem
     */
    private boolean validaPosicao() {

        Tela tela = Desenho.acessoATelaDoJogo();

        if (!tela.ehPosicaoValida(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }

        // Verifica colisão com outros personagens
        for (Personagem p : tela.getFaseAtual()) {
            // com mobs
            if (p != this && !(p instanceof Item)
                    && p.getPosicao().igual(this.getPosicao())) {
                this.perdeVida(); // perde vida

                return false;
            }
        }
        return true;
    }

    public boolean moveUp() {
        if (super.moveUp())
            return validaPosicao();
        return false;
    }

    public boolean moveDown() {
        if (super.moveDown())
            return validaPosicao();
        return false;
    }

    public boolean moveRight() {
        if (super.moveRight())
            return validaPosicao();
        return false;
    }

    public boolean moveLeft() {
        if (super.moveLeft())
            return validaPosicao();
        return false;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int v) {
        this.vida = v;
    }

    public void perdeVida() {
        this.vida--;
        if (this.vida <= 0) {
            System.out.println("Você morreu");
            this.respawn();
        } else {
            this.voltaAUltimaPosicao();
        }
        System.out.println("Você tem: " + this.vida + " vidas");
    }

    public boolean ganhaVida() {
        if (this.vida < VIDA_MAXIMA) {
            this.vida++;
            System.out.println("Você tem: " + this.vida + " vidas");
            return true;
        } else {
            System.out.println("Vida cheia");
            return false;
        }

    }

    public void respawn() {

        this.vida = VIDA_MAXIMA;
        this.setPosicao(1, 1);

    }

    public void setChave(int c) {
        chave = c;
    }

    public int getChave() {
        return chave;
    }

}
