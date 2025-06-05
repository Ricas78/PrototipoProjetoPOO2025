package Modelo.MOBS;

//mob que se movimenta horizontalmente
public class MobH extends Mob {

    protected boolean esquerda;

    // é passado o nome do arquivo de skin do mob, o quanto ele deve percorrer do
    // mapa, o seu delay de frames de movimentação e se ele deve se movimentar da
    // direita-esquerda ou esquerda-direita
    public MobH(String sNomeImagePNG, int totalPassos, int delay, boolean esquerda) {
        super(sNomeImagePNG, delay);
        this.totalPassos = totalPassos;
        this.esquerda = esquerda; // sentido = true (começa indo pra esquerda)
        this.passosDados = 0;
        this.bTransponivel = true;
    }

    @Override
    public void autoDesenho() {
        contFrames++;

        if (contFrames >= delay) { // Delay de frames entre cada passo
            contFrames = 0;

            int novaColuna = pPosicao.getColuna();

            if (totalPassos > 0) {
                // Decide direção
                if (esquerda) {
                    novaColuna -= 1;
                } else {
                    novaColuna += 1;
                }
            }

            // Move uma casa
            this.setPosicao(pPosicao.getLinha(), novaColuna);
            validaPosicao();

            passosDados++;

            // Se chegou no número total de passos, inverte a direção
            if (passosDados >= totalPassos) {
                passosDados = 0;
                esquerda = !esquerda;
            }
        }

        super.autoDesenho();
    }

}
