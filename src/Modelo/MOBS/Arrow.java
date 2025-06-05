package Modelo.MOBS;

import Auxiliar.Desenho;
import Modelo.Projetil;

//mob que dispara projeteis verticalmente e anda horizontalmente
public class Arrow extends MobH {

    private int iContaIntervalos;
    private boolean up;

    // é passado o nome do arquivo de skin do mob, o quanto ele deve percorrer do
    // mapa, o seu delay de frames de movimentação, se ele deve se movimentar da
    // direita-esquerda ou esquerda-direita e se o projetil deve ser pra cima ou pra
    // baixo
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
