package UI;

import Constants.Constants;
import Main.KeyHandler;
import Util.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class TitleScreen extends JPanel implements Runnable {
    private static final String[] MENUS = new String[]{"START GAME", "OPTIONS", "EXIT"};
    ArrayList<MenuItems> menuItems;
    KeyHandler keyH = new KeyHandler();
    int FPS = Constants.FPS;
    UIManager manager;
    Thread thread;
    MenuBuilder menuBuilder;

    public TitleScreen(UIManager manager){
        this.setPreferredSize(new Dimension(Constants.screenWidth, Constants.screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.manager = manager;
        this.setFocusable(true);
        this.addKeyListener(keyH);
        this.setName("Title");
    }

    public void start(){
        this.thread = new Thread(this, "Title");
        this.thread.start();
    }

    public void stop(){
        if(this.thread != null){
            Thread temp = this.thread;
            this.thread = null;
            temp.interrupt();
        }
    }


    private void drawTitle(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.setFont(Constants.titleFont);
        String titleText = "ISOCHESS";
        int x = Utils.getCenterXString(titleText, g2);
        System.out.printf("X at %d%n", x);
        int y = Constants.screenHeight / 4;
        g2.drawString(titleText, x, y);
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        this.drawTitle(g2);
        this.menuBuilder = new MenuBuilder(MENUS,keyH,g2);
    }

    @Override
    public void run() {

    }
}
