package Modelo.MOBS;

import Auxiliar.Desenho;
import Modelo.Projetil;

//mob que se teleporta ao longo de uma região delimitada do mapa e solta projeteis
public class Wizzard extends Mob {

    private int position;

    // é passado o nome do arquivo de skin do mob, a distância que ele deve
    // teleportar do seu ponto de posicionamento inicial e o seu delay de frames de
    // movimentação
    public Wizzard(String sNomeImagePNG, int totalPassos, int delay) {
        super(sNomeImagePNG, delay);
        this.totalPassos = totalPassos;
    }

    @Override
    public void autoDesenho() {
        contFrames++;

        if (contFrames >= delay) { // Delay de frames entre cada totalPassoso
            contFrames = 0;

            int novaColuna = pPosicao.getColuna();
            int novaLinha = pPosicao.getLinha();

            // Decide direção
            if (position == 0) {
                position = 1;
                this.setPosicao(novaLinha, novaColuna);
            }

            else if (position == 1) {
                novaColuna -= totalPassos;
                position = 2;
                this.setPosicao(novaLinha, novaColuna);
                Projetil f = new Projetil("fireD.png", 2);
                f.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(f);

            } else if (position == 2) {
                novaColuna += totalPassos;
                novaLinha -= totalPassos;
                position = 3;
                this.setPosicao(novaLinha, novaColuna);
                Projetil f = new Projetil("fireL.png", 3);
                f.setPosicao(pPosicao.getLinha(), pPosicao.getColuna() - 1);
                Desenho.acessoATelaDoJogo().addPersonagem(f);
            }

            else if (position == 3) {
                novaColuna += totalPassos;
                novaLinha += totalPassos;
                this.setPosicao(novaLinha, novaColuna);
                Projetil f = new Projetil("fireU.png", 0);
                f.setPosicao(pPosicao.getLinha() - 1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(f);
                position = 4;

            } else if (position == 4) {
                novaColuna -= totalPassos;
                novaLinha += totalPassos;
                this.setPosicao(novaLinha, novaColuna);
                Projetil f = new Projetil("fireD.png", 2);
                f.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(f);
                position = 5;
            }

            else if (position == 5) {
                novaColuna -= totalPassos;
                novaLinha -= totalPassos;
                this.setPosicao(novaLinha, novaColuna);
                Projetil f = new Projetil("fireD.png", 2);
                f.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(f);
                position = 2;
            }
            validaPosicao();
        }

        super.autoDesenho();
    }

}
