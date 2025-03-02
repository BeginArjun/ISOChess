package Main;

import Constants.Constants;
import Game.Board;
import Game.GameState;
import UI.TitleScreen;
import UI.UIManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 32;  // 32 X 32
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;

    // 16 : 9 Ratio
    public final int maxScreenCol = 32;
    public final int maxScreenRow = 18;

    public static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    int FPS = 60;
    Thread gameThread;

    KeyHandler kh = new KeyHandler();
    UIManager manager;
    Board board;

    public GamePanel(UIManager manager){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setName("Game");
        this.addKeyListener(kh);
        this.manager = manager;
        this.board = new Board();
    }

    public void startGame(){
        gameThread = new Thread(this,"Game Thread");
        gameThread.start();
    }

    public void stopGame(){
        System.out.println("Stopping sir");
        if(gameThread != null){
            Thread temp = gameThread;
            gameThread = null;
            temp.interrupt();
        }
    }

    private void checkPause(){
        if(this.kh.escPressed){
            System.out.println("Bingo");
            manager.showTitleScreen();
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        board.generateBoard(g2,this);


        g2.dispose();
    }

    public void update(){
        checkPause();
    }

    // Game Loop
    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS; // Nanoseconds per frame
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null){
            System.out.println("Running sir");
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }
}
