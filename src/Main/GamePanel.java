package Main;

import Game.Board;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 32;  // 32 X 32
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;

    // 16 : 9 Ratio
    public final int maxScreenCol = 32;
    public final int maxScreenRow = 18;

    public final int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    public final int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    int FPS = 60;
    Thread gameThread;

    Board board;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.board = new Board();
    }

    public void startGame(){
        gameThread = new Thread("Game Thread");
        gameThread.start();
    }

    public void paintComponent(Graphics g){
        System.out.println("Running paint");
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        board.generateBoard(g2,this);

        g2.dispose();
    }


    // Game Loop
    @Override
    public void run() {

    }
}
