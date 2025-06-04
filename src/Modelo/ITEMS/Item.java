package Modelo.ITEMS;

import Auxiliar.Desenho;
import Modelo.Personagem;

public abstract class Item extends Personagem {

    public Item(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }

    public void autoDesenho() {
        super.autoDesenho();
        if (this.validaPosicao()) {
            Desenho.acessoATelaDoJogo().removePersonagem(this);
        }
    }

    public abstract boolean validaPosicao();
}
