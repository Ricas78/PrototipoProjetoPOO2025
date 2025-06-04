package Auxiliar;

import java.io.File;

public class Consts {
    public static final int CELL_SIDE = 50; // resolução em pixels de cada celula da matriz display
    public static final int RES = 16; // visível na tela, camera que acompanha o personagem
    public static final int MUNDO_LARGURA = 16; // largura limite do mundo
    public static final int MUNDO_ALTURA = 30; // altura limite do mundo
    public static final int PERIOD = 200; // periodo de atualização de frames
    public static final String PATH = File.separator + "imgs" + File.separator;
    public static final int TIMER = 10;
    public static final int MAX_KEYS = 5;
}