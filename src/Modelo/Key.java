package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;
import Auxiliar.Consts;

public class Key extends Personagem {

    public Key(String sNomeImagePNG) {
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
                    return ganhaChave((Hero) p); // ganha chave
                }
            }
        }
        return false;
    }

    private boolean ganhaChave(Hero h) {
        if (h.getChave() < Consts.MAX_KEYS) {
            h.setChave(h.getChave() + 1);
            System.out.println("Você tem: " + h.getChave() + " chaves");
            return true;
        } else {
            System.out.println("max chaves");
            return false;
        }
    }
}
