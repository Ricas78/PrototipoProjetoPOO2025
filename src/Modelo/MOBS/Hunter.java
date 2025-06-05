package Modelo.MOBS;

import Auxiliar.Posicao;

//Mob que persegue o personagem e se colidir com ele dá dano
public class Hunter extends Mob {

    private boolean iDirectionV;
    private boolean iDirectionH;

    // é passado o nome do arquivo de skin do mob, e o valor de delay de
    // movimentação
    public Hunter(String sNomeImagePNG, int delay) {
        super(sNomeImagePNG, delay);
        iDirectionV = true;
        iDirectionH = true;

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
}
