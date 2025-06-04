package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class Caveira extends Personagem implements Serializable {
    private int iContaIntervalos;

    public Caveira(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        bMortal = false;
        this.iContaIntervalos = 0;
    }

    public void autoDesenho() {
        super.autoDesenho();

        this.iContaIntervalos++;
        if (this.iContaIntervalos == Consts.TIMER) {
            this.iContaIntervalos = 0;
            Fogo[] f = new Fogo[2];
            f[0] = new Fogo("fire.png", 0);
            f[1] = new Fogo("fire.png", 0);

            f[0].setPosicao(pPosicao.getLinha() - 1, pPosicao.getColuna());
            Desenho.acessoATelaDoJogo().addPersonagem(f[0]);

            f[1].setPosicao(pPosicao.getLinha() - 1, pPosicao.getColuna() + 1);
            Desenho.acessoATelaDoJogo().addPersonagem(f[1]);
        }
    }
}
