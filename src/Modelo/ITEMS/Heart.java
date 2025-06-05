package Modelo.ITEMS;

import Auxiliar.Desenho;
import Controler.Tela;
import Modelo.Hero;
import Modelo.Personagem;

//classe do item de vida do jogo
public class Heart extends Item {

    public Heart(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }

    public void autoDesenho() {
        super.autoDesenho();
    }

    public boolean validaPosicao() {

        Tela tela = Desenho.acessoATelaDoJogo();

        // Verifica colisão com o heroi, se sim, ele ganha vida
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
