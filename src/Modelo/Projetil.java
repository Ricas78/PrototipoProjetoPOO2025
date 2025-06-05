package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;
import Modelo.MOBS.*;

import java.util.ArrayList;
import java.util.List;

public class Projetil extends Personagem {
    private int dir;

    public Projetil(String sNomeImagePNG, int dir) {
        super(sNomeImagePNG);
        this.bMortal = false;
        this.dir = dir;
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
        switch (dir) {
            case 0:
                if (!this.moveUp()) {
                    Desenho.acessoATelaDoJogo().removePersonagem(this);
                }
                break;

            case 1:
                if (!this.moveRight()) {
                    Desenho.acessoATelaDoJogo().removePersonagem(this);
                }
                break;
            case 2:
                if (!this.moveDown()) {
                    Desenho.acessoATelaDoJogo().removePersonagem(this);
                }
                break;
            case 3:
                if (!this.moveLeft()) {
                    Desenho.acessoATelaDoJogo().removePersonagem(this);
                }
                break;
            default:
                if (!this.moveUp()) {
                    Desenho.acessoATelaDoJogo().removePersonagem(this);
                }
                break;
        }

        validaPosicao();

    }

    public boolean validaPosicao() {

        Tela tela = Desenho.acessoATelaDoJogo();

        List<Personagem> personagens = new ArrayList<>(tela.getFaseAtual());

        // Verifica colisão com outros personagens
        for (Personagem p : personagens) {
            if (p instanceof Hero) {
                if (p.getPosicao().igual(this.getPosicao())) {
                    ((Hero) p).perdeVida(); // perde vida
                    Desenho.acessoATelaDoJogo().removePersonagem(this);

                    return false;
                }
            }

            else if (((p instanceof Wall) || (p instanceof Mob)) && p.getPosicao().igual(this.getPosicao())) {
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            }

        }
        return true;
    }

}
