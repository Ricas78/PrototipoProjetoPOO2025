/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Auxiliar.Desenho;
import Auxiliar.Posicao;
import Controler.Tela;

/**
 *
 * @author 2373891
 */
public class Chaser extends Personagem {

    private boolean iDirectionV;
    private boolean iDirectionH;
    private int delay;
    private int contFrames;

    public Chaser(String sNomeImagePNG, int delay) {
        super(sNomeImagePNG);
        iDirectionV = true;
        iDirectionH = true;
        this.delay = delay;
        contFrames = 0;

        this.bTransponivel = false;
    }

    public void computeDirection(Posicao heroPos) {
        if (heroPos.getColuna() <= this.getPosicao().getColuna()) {
            iDirectionH = true;

        } else if (heroPos.getColuna() >= this.getPosicao().getColuna()) {
            iDirectionH = false;
        }

        if (heroPos.getLinha() <= this.getPosicao().getLinha()) {
            iDirectionV = true;

        } else if (heroPos.getLinha() >= this.getPosicao().getLinha()) {
            iDirectionV = false;
        }
    }

    public void autoDesenho() {
        super.autoDesenho();
        contFrames++;
        if (contFrames >= delay) {
            contFrames = 0;
            if (iDirectionH) {
                this.moveLeft();
                validaPosicao();
            } else {
                this.moveRight();
                validaPosicao();
            }
            if (iDirectionV) {
                this.moveUp();
                validaPosicao();
            } else {
                this.moveDown();
                validaPosicao();
            }

        }
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
