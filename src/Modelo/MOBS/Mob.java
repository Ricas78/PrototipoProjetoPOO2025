package Modelo.MOBS;

import Auxiliar.Desenho;
import Controler.Tela;
import Modelo.Hero;
import Modelo.Personagem;

public class Mob extends Personagem {

    protected int totalPassos;
    protected int passosDados;
    protected int delay;
    protected int contFrames;

    public Mob(String sNomeImagePNG, int delay) {
        super(sNomeImagePNG);

        this.delay = delay;
        this.contFrames = 0;

    }

    public boolean validaPosicao() {
        Tela tela = Desenho.acessoATelaDoJogo();

        for (Personagem p : tela.getFaseAtual()) {
            if (p instanceof Hero) {
                if (p.getPosicao().igual(this.getPosicao())) {
                    ((Hero) p).perdeVida();
                    return false;
                }
            }
        }
        return true;
    }

    public void autoDesenho() {
        super.autoDesenho();
    }
}
