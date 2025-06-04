package Modelo.MOBS;

import Auxiliar.Desenho;
import Modelo.Projetil;

public class Arrow extends MobH {

    private int iContaIntervalos;
    private boolean up;

    public Arrow(String sNomeImagePNG, int walk, int delay, boolean esquerda, boolean up) {
        super(sNomeImagePNG, walk, delay, esquerda);
        this.up = up;
        this.iContaIntervalos = 0;
    }

    public void autoDesenho() {
        super.autoDesenho();

        iContaIntervalos++;
        if (iContaIntervalos == delay) {
            iContaIntervalos = 0;
            if (up) {
                Projetil f = new Projetil("flecha.png", 0);
                f.setPosicao(pPosicao.getLinha() - 1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(f);
            } else {
                Projetil f = new Projetil("flechaD.png", 2);
                f.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(f);
            }

        }
    }

}
