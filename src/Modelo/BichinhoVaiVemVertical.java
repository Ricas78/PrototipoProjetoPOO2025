
package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;

public class BichinhoVaiVemVertical extends Personagem {
    private int contFrames;
    private int passosDados;
    private int totalPassos;
    private boolean invertido;
    private int delay;

    public BichinhoVaiVemVertical(String sNomeImagePNG, int walk, int delay, boolean sentido) {
        super(sNomeImagePNG);
        this.totalPassos = walk;
        this.invertido = sentido; // sentido = true (começa indo pra cima)
        this.delay = delay;
        this.contFrames = 0;
        this.passosDados = 0;
        this.bTransponivel = true;
    }

    @Override
    public void autoDesenho() {
        contFrames++;

        if (contFrames >= delay) { // Delay de 4 frames entre cada passo
            contFrames = 0;

            int novaLinha = pPosicao.getLinha();

            // Decide direção
            if (invertido) {
                novaLinha -= 1;
            } else {
                novaLinha += 1;
            }

            // Move uma casa
            this.setPosicao(novaLinha, pPosicao.getColuna());
            validaPosicao();

            passosDados++;

            // Se chegou no número total de passos, inverte a direção
            if (passosDados >= totalPassos) {
                passosDados = 0;
                invertido = !invertido;
            }
        }

        super.autoDesenho();

    }

    // Tratamento pra lidar com a colisão com o heroi
    private boolean validaPosicao() {

        Tela tela = Desenho.acessoATelaDoJogo();

        // Verifica colisão com outros personagens
        for (Personagem p : tela.getFaseAtual()) {
            if (p instanceof Hero) {
                if (p.getPosicao().igual(this.getPosicao())) {
                    ((Hero) p).perdeVida(); // perde vida

                    return false;
                }
            }
        }
        return true;
    }
}
