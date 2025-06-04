package Modelo;

import Auxiliar.Desenho;

public class ArrowSK extends MobHorizontal {
    private int iContaIntervalos;
    private int delay;
    private boolean up;

    public ArrowSK(String sNomeImagePNG, int walk, int delay, boolean sentido, boolean up) {
        super(sNomeImagePNG, walk, delay, sentido);
        this.bTransponivel = true;
        bMortal = false;
        this.up = up;
        this.delay = delay;
        this.iContaIntervalos = 0;
    }

    public void autoDesenho() {
        super.autoDesenho();

        this.iContaIntervalos++;
        if (this.iContaIntervalos == delay) {
            this.iContaIntervalos = 0;
            if (up) {
                Fogo f = new Fogo("flecha.png", 0);
                f.setPosicao(pPosicao.getLinha() - 1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(f);
            } else {
                Fogo f = new Fogo("flechaD.png", 2);
                f.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(f);
            }

        }
    }
}
