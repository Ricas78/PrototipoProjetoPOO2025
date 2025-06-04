package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;

public class Heart extends Personagem {

    public Heart(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
        if (this.validaPosicao()) {
            Desenho.acessoATelaDoJogo().removePersonagem(this);
        }
    }

    private boolean validaPosicao() {

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
