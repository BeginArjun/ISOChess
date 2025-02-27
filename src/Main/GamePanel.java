package Main;

import Game.Board;
import Game.GameState;
import UI.TitleScreen;

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

    Board board;
    GameState gameState;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.gameState = new GameState();
        this.board = new Board();
    }

    public void startGame(){
        gameThread = new Thread("Game Thread");
        gameThread.start();
    }

    @Override
    protected void paintComponent(Graphics g){
        System.out.println("Running paint");
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        GameState.State currentGameState = this.gameState.getState();

        switch (currentGameState){
            case TITLE :
                TitleScreen titleScreen = new TitleScreen();
                titleScreen.drawTitleScreen(g2, this);
                break;
            case GAME:
                board.generateBoard(g2,this);
                break;
            default:
                break;
        }

        g2.dispose();
    }

    public void update(){

    }

    // Game Loop
    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS; // Nanoseconds per frame
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null){
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
