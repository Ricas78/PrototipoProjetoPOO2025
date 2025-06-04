package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MobHorizontal extends Personagem implements Serializable {

    private int contFrames;
    private int passosDados;
    private int totalPassos;
    private boolean invertido;
    private int delay;

    public MobHorizontal(String sNomeImagePNG, int walk, int delay, boolean sentido) {
        super(sNomeImagePNG);
        this.totalPassos = walk;
        this.invertido = sentido; // sentido = true (começa indo pra esquerda)
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

            int novaColuna = pPosicao.getColuna();

            if (totalPassos > 0) {
                // Decide direção
                if (invertido) {
                    novaColuna -= 1;
                } else {
                    novaColuna += 1;
                }
            }

            // Move uma casa
            this.setPosicao(pPosicao.getLinha(), novaColuna);
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
}
