package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;
import Modelo.MOBS.*;

import java.util.ArrayList;
import java.util.List;

//classe de Objetos criados/lançados por outros personagens
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
        // escolhe a direção do projetil
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
        // verifica a colisão
        validaPosicao();

    }

    public boolean validaPosicao() {

        Tela tela = Desenho.acessoATelaDoJogo();

        List<Personagem> personagens = new ArrayList<>(tela.getFaseAtual());

        // Verifica colisão com outros personagens, se for o heroi, ele perde vida
        for (Personagem p : personagens) {
            if (p instanceof Hero) {
                if (p.getPosicao().igual(this.getPosicao())) {
                    ((Hero) p).perdeVida(); // perde vida
                    Desenho.acessoATelaDoJogo().removePersonagem(this);

                    return false;
                }
            }
            // verifica colisão com estruturas ou mobs, se colidir, o projetil desaparece
            else if (((p instanceof Wall) || (p instanceof Mob)) && p.getPosicao().igual(this.getPosicao())) {
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            }

        }
        return true;
    }

}
