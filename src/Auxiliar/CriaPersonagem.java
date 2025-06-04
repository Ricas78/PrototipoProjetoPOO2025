package Auxiliar;

import java.io.*;
import java.util.zip.GZIPOutputStream;
import Modelo.*;
import Modelo.Personagem;

public class CriaPersonagem {
    public static void main(String[] args) throws Exception {
        Personagem p = new Caveira("caveira.png");

        File file = new File("Caveira.zip");
        FileOutputStream fos = new FileOutputStream(file);
        GZIPOutputStream gzipOut = new GZIPOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(gzipOut);

        oos.writeObject(p);
        oos.close();
        System.out.println("Personagem salvo em: " + file.getAbsolutePath());
    }
}
