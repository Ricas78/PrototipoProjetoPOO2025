package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;

import java.util.Random;

public class ZigueZague extends Personagem {

    private int contFrames;
    private int passosDados;
    private int totalPassos;
    private boolean invertido;
    private int delay;
    private int position;

    public ZigueZague(String sNomeImagePNG, int walk, int delay) {
        super(sNomeImagePNG);
        this.totalPassos = walk;
        // this.invertido = sentido; // sentido = true (começa indo pra esquerda)
        this.delay = delay;
        this.contFrames = 0;
        position = 0;
        // this.passosDados = 0;
        this.bTransponivel = true;
    }

    @Override
    public void autoDesenho() {
        contFrames++;

        if (contFrames >= delay) { // Delay de 4 frames entre cada passo
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
                Fogo f = new Fogo("fireD.png", 2);
                f.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(f);

            } else if (position == 2) {
                novaColuna += totalPassos;
                novaLinha -= totalPassos;
                position = 3;
                this.setPosicao(novaLinha, novaColuna);
                Fogo f = new Fogo("fireL.png", 3);
                f.setPosicao(pPosicao.getLinha(), pPosicao.getColuna() - 1);
                Desenho.acessoATelaDoJogo().addPersonagem(f);
            }

            else if (position == 3) {
                novaColuna += totalPassos;
                novaLinha += totalPassos;
                this.setPosicao(novaLinha, novaColuna);
                Fogo f = new Fogo("fireU.png", 0);
                f.setPosicao(pPosicao.getLinha() - 1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(f);
                position = 4;

            } else if (position == 4) {
                novaColuna -= totalPassos;
                novaLinha += totalPassos;
                this.setPosicao(novaLinha, novaColuna);
                Fogo f = new Fogo("fireD.png", 2);
                f.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(f);
                position = 5;
            }

            else if (position == 5) {
                novaColuna -= totalPassos;
                novaLinha -= totalPassos;
                this.setPosicao(novaLinha, novaColuna);
                Fogo f = new Fogo("fireD.png", 2);
                f.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(f);
                position = 2;
            }

            // Move uma casa
            // this.setPosicao(novaLinha, novaColuna);
            validaPosicao();

            // passosDados++;

            // // Se chegou no número total de passos, inverte a direção
            // if (passosDados >= totalPassos) {
            // passosDados = 0;
            // invertido = !invertido;
            // }
        }

        super.autoDesenho();
    }

    private boolean validaPosicao() {
        Tela tela = Desenho.acessoATelaDoJogo();

        for (Personagem p : tela.getFaseAtual()) {
            if (p instanceof Hero) {
                if (p.getPosicao().igual(this.getPosicao())) {
                    ((Hero) p).perdeVida();
                    return false;
                }
            }
        }
        return true;
    }

    // public ZigueZague(String sNomeImagePNG) {
    // super(sNomeImagePNG);
    // }

    // public void autoDesenho() {
    // // Random rand = new Random();
    // int iDirecao = 1;

    // if (iDirecao == 1) {
    // this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna() + 1);
    // iDirecao++;
    // super.autoDesenho();
    // }
    // if (iDirecao == 2) {
    // this.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
    // iDirecao++;
    // super.autoDesenho();
    // }
    // if (iDirecao == 3) {
    // this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna() - 1);
    // iDirecao++;
    // super.autoDesenho();
    // }
    // if (iDirecao == 4) {
    // this.setPosicao(pPosicao.getLinha() - 1, pPosicao.getColuna());
    // iDirecao = 0;
    // super.autoDesenho();
    // }

    // super.autoDesenho();
    // }
}
