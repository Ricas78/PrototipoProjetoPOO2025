package Modelo;

import Auxiliar.Desenho;

public class Wall extends Personagem {

    public Wall(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = false;
        this.bTransponivel = false;
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }

}
