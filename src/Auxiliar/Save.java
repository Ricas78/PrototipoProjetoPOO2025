package Auxiliar;

import java.io.Serializable;
import java.util.ArrayList;
import Modelo.Personagem;
import Modelo.FASES.*;

//Classe para armazenar os dados relevantes em um save
public class Save implements Serializable {

    public int numeroDaFaseAtual;
    public Fase fase;
    public ArrayList<Personagem> faseAtual;

    public Save(int numFase, Fase fase, ArrayList<Personagem> personagens) {
        this.numeroDaFaseAtual = numFase;
        this.fase = fase;
        this.faseAtual = personagens;
    }
}
