package Modelo.ITEMS;

import Auxiliar.Desenho;
import Controler.Tela;
import Modelo.Hero;
import Modelo.Personagem;

public class Heart extends Item {

    public Heart(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }

    public void autoDesenho() {
        super.autoDesenho();
    }

    public boolean validaPosicao() {

        Tela tela = Desenho.acessoATelaDoJogo();

        // Verifica colisão com o heroi
        for (Personagem p : tela.getFaseAtual()) {
            if (p instanceof Hero) {
                if (p.getPosicao().igual(this.getPosicao())) {
                    return ((Hero) p).ganhaVida(); // ganha vida
                }
            }
        }
        return false;
    }

}
