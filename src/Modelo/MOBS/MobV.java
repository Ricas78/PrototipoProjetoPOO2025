package Modelo.MOBS;

public class MobV extends Mob {

    protected boolean down;

    public MobV(String sNomeImagePNG, int totalPassos, int delay, boolean down) {
        super(sNomeImagePNG, delay);
        this.totalPassos = totalPassos;
        this.down = down; // sentido = true (começa indo pra esquerda)
        this.passosDados = 0;
        this.bTransponivel = true;
    }

    @Override
    public void autoDesenho() {
        contFrames++;

        if (contFrames >= delay) { // Delay de frames entre cada passo
            contFrames = 0;

            int novaLinha = pPosicao.getLinha();

            // Decide direção
            if (down) {
                novaLinha -= 1;
            } else {
                novaLinha += 1;
            }

            // Move uma casa
            this.setPosicao(novaLinha, pPosicao.getColuna());
            validaPosicao();

            passosDados++;

            // Se chegou no número total de passos, inverte a direção
            if (passosDados >= totalPassos) {
                passosDados = 0;
                down = !down;
            }
        }

        super.autoDesenho();

    }

}
