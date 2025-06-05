package Modelo.ITEMS;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import Modelo.Hero;
import Modelo.Personagem;

//classe do item que permite a passagem de fase
public class Key extends Item {

    public Key(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }

    public void autoDesenho() {
        super.autoDesenho();
    }

    public boolean validaPosicao() {
        Tela tela = Desenho.acessoATelaDoJogo();

        // Verifica colisão com o heroi, se sim, ele armazena uma chave
        for (Personagem p : tela.getFaseAtual()) {
            if (p instanceof Hero) {
                if (p.getPosicao().igual(this.getPosicao())) {
                    return ganhaChave((Hero) p); // ganha chave
                }
            }
        }
        return false;
    }

    public boolean ganhaChave(Hero h) {
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
