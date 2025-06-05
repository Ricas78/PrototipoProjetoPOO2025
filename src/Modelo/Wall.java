package Modelo;

//classe que gera uma estrutura intransponivel para o heroi, alguns mobs e projeteis
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
