package Auxiliar;

import java.io.*;
import java.util.zip.GZIPOutputStream;
import Modelo.MOBS.*;
import Modelo.Personagem;;

//Classe que cria um Objeto de cada mob do jogo em um zip pra ser colocado em qualquer posição de cada mapa
public class CriaPersonagem {
    public static void main(String[] args) throws Exception {
        Personagem p = new Arrow("arrow.png", 0, 1, true, true);

        File file = new File("Arrow.zip");
        FileOutputStream fos = new FileOutputStream(file);
        GZIPOutputStream gzipOut = new GZIPOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(gzipOut);

        oos.writeObject(p);
        oos.close();
        System.out.println("Personagem salvo em: " + file.getAbsolutePath());

        Personagem p1 = new MobV("warriorSk.png", 1, 1, true);

        File file1 = new File("MobVertical.zip");
        FileOutputStream fos1 = new FileOutputStream(file1);
        GZIPOutputStream gzipOut1 = new GZIPOutputStream(fos1);
        ObjectOutputStream oos1 = new ObjectOutputStream(gzipOut1);

        oos1.writeObject(p1);
        oos1.close();
        System.out.println("Personagem salvo em: " + file.getAbsolutePath());

        Personagem p2 = new MobH("slime.png", 1, 1, true);

        File file2 = new File("MobHorizontal.zip");
        FileOutputStream fos2 = new FileOutputStream(file2);
        GZIPOutputStream gzipOut2 = new GZIPOutputStream(fos2);
        ObjectOutputStream oos2 = new ObjectOutputStream(gzipOut2);

        oos2.writeObject(p2);
        oos2.close();
        System.out.println("Personagem salvo em: " + file.getAbsolutePath());

        Personagem p3 = new Wizzard("WizzardSK.png", 1, 4);

        File file3 = new File("Wizzard.zip");
        FileOutputStream fos3 = new FileOutputStream(file3);
        GZIPOutputStream gzipOut3 = new GZIPOutputStream(fos3);
        ObjectOutputStream oos3 = new ObjectOutputStream(gzipOut3);

        oos3.writeObject(p3);
        oos3.close();
        System.out.println("Personagem salvo em: " + file.getAbsolutePath());

        Personagem p4 = new Hunter("ghost.png", 4);

        File file4 = new File("Hunter.zip");
        FileOutputStream fos4 = new FileOutputStream(file4);
        GZIPOutputStream gzipOut4 = new GZIPOutputStream(fos4);
        ObjectOutputStream oos4 = new ObjectOutputStream(gzipOut4);

        oos4.writeObject(p4);
        oos4.close();
        System.out.println("Personagem salvo em: " + file.getAbsolutePath());
    }
}
