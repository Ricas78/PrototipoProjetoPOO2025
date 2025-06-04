package Controler;

import Modelo.Fase4;
import Auxiliar.Save;
import Modelo.Fase;
import Modelo.Fase0;
import Modelo.Fase1;
import Modelo.Fase2;
import Modelo.Fase3;
import Modelo.Personagem;
import Modelo.Caveira;
import Modelo.Hero;
import Modelo.Chaser;
import Modelo.BichinhoVaiVemHorizontal;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Modelo.BichinhoVaiVemVertical;
import Modelo.ZigueZague;
import Auxiliar.Posicao;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener, Serializable {

    private Hero hero;
    private ArrayList<Personagem> faseAtual;
    private transient ControleDeJogo cj = new ControleDeJogo();
    private transient Graphics g2;
    private int cameraLinha = 0;
    private int cameraColuna = 0;
    private Fase fase;

    private int numeroDaFaseAtual = 1; // CONTADOR DE FASE

    public Tela() {
        Desenho.setCenario(this);
        initComponents();
        this.addMouseListener(this);
        this.addKeyListener(this);

        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        faseAtual = new ArrayList<>();
        fase = new Fase0();
        hero = fase.getHero();
        faseAtual = fase.getPersonagens();
        this.atualizaCamera();
    }

    public int getCameraLinha() {
        return cameraLinha;
    }

    public int getCameraColuna() {
        return cameraColuna;
    }

    public boolean ehPosicaoValida(Posicao p) {
        return cj.ehPosicaoValida(this.faseAtual, p);
    }

    public void addPersonagem(Personagem umPersonagem) {
        faseAtual.add(umPersonagem);
    }

    public void removePersonagem(Personagem umPersonagem) {
        faseAtual.remove(umPersonagem);
    }

    public Graphics getGraphicsBuffer() {
        return g2;
    }

    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                int mapaLinha = cameraLinha + i;
                int mapaColuna = cameraColuna + j;

                if (mapaLinha < Consts.MUNDO_ALTURA && mapaColuna < Consts.MUNDO_LARGURA) {
                    try {
                        Image newImage = Toolkit.getDefaultToolkit().getImage(
                                new java.io.File(".").getCanonicalPath() + Consts.PATH + fase.getWallpaper());
                        g2.drawImage(newImage,
                                j * Consts.CELL_SIDE, i * Consts.CELL_SIDE,
                                Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                    } catch (IOException ex) {
                        Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        if (!this.faseAtual.isEmpty()) {
            this.cj.desenhaTudo(faseAtual);
            this.cj.processaTudo(faseAtual);
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    private void atualizaCamera() {
        int linha = hero.getPosicao().getLinha();
        int coluna = hero.getPosicao().getColuna();

        cameraLinha = Math.max(0, Math.min(linha - Consts.RES / 2, Consts.MUNDO_ALTURA - Consts.RES));
        cameraColuna = Math.max(0, Math.min(coluna - Consts.RES / 2, Consts.MUNDO_LARGURA - Consts.RES));
    }

    public void go() {
        TimerTask task = new TimerTask() {
            public void run() {
                // Verifica se o herói pegou a chave
                if (hero.getChave() == Consts.MAX_KEYS) {
                    trocarDeFase();
                    hero.setChave(0); // Zera a chave após trocar de fase
                }
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.PERIOD);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
            this.faseAtual.clear();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_M) { // TECLA M PARA TROCAR DE FASE
            trocarDeFase();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            salvarJogo();
        } else if (e.getKeyCode() == KeyEvent.VK_L) {
            carregarJogo();
        }

        this.atualizaCamera();
        this.setTitle("-> Cell: " + (hero.getPosicao().getLinha()) + ", " + (hero.getPosicao().getColuna()));
    }

    // TROCAR DE FASE
    private void trocarDeFase() {
        switch (numeroDaFaseAtual) {
            case 0:
                fase = new Fase0();
                break;
            case 1:
                fase = new Fase1();
                break;
            case 2:
                fase = new Fase2();
                break;
            case 3:
                fase = new Fase3();
                break;
            case 4:
                fase = new Fase4();
                break;
            default:
                System.out.println("Todas as fases completas!");
                return; // Não troca de fase se passar do número máximo
        }

        hero = fase.getHero();
        faseAtual = fase.getPersonagens();
        atualizaCamera();
        numeroDaFaseAtual++; // INCREMENTA APÓS carregar a nova fase
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        this.setTitle("X: " + x + ", Y: " + y + " -> Cell: " + (y / Consts.CELL_SIDE) + ", " + (x / Consts.CELL_SIDE));
        this.hero.getPosicao().setPosicao(y / Consts.CELL_SIDE, x / Consts.CELL_SIDE);
        repaint();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Skooter");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 561, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 500, Short.MAX_VALUE));

        pack();
    }

    private void salvarJogo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("savegame.dat"))) {
            Save estado = new Save(numeroDaFaseAtual, fase, faseAtual);
            oos.writeObject(estado);
            System.out.println("Jogo salvo com sucesso.");
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarJogo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("savegame.dat"))) {
            Save estado = (Save) ois.readObject();
            this.numeroDaFaseAtual = estado.numeroDaFaseAtual;
            this.fase = estado.fase;
            this.faseAtual = estado.faseAtual;
            this.hero = estado.fase.getHero();
            ois.close();
            System.out.println("Jogo carregado com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Abre seletor de arquivo
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                FileInputStream fis = new FileInputStream(file);
                GZIPInputStream gzipIn = new GZIPInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(gzipIn);

                // Lê personagem
                Personagem p = (Personagem) ois.readObject();
                ois.close();

                // Converte posição do mouse para posição no grid
                int linha = e.getY() / Consts.CELL_SIDE;
                int coluna = e.getX() / Consts.CELL_SIDE;

                // Corrige coordenadas com base na câmera
                linha += cameraLinha;
                coluna += cameraColuna;

                // Seta posição e adiciona
                p.setPosicao(linha, coluna);
                this.addPersonagem(p);

                repaint();
                System.out.println("Personagem adicionado em (" + linha + ", " + coluna + ")");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public ArrayList<Personagem> getFaseAtual() {
        return faseAtual;
    }
}
