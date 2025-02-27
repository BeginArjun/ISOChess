package UI;

import Main.GamePanel;
import Util.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class TitleScreen {
    Font titleFont, menuFont;
    private static String[] MENUS = {"START GAME","OPTIONS", "EXIT"};

    public TitleScreen(){
        this.titleFont = new Font("Arial", Font.BOLD, 120);
        this.menuFont = new Font("Arial", Font.PLAIN,64);
    }


    private void drawTitle(Graphics2D g2, GamePanel gp){
        g2.setColor(Color.WHITE);
        g2.setFont(titleFont);
        String titleText = "ISOCHESS";
        int x = Utils.getCenterXString(titleText, gp, g2);
        System.out.println(String.format("X at %d", x));
        int y = gp.screenHeight / 4;
        g2.drawString(titleText, x, y);
    }

    private void drawMenu(Graphics2D g2, GamePanel gp){
        g2.setFont(menuFont);
        int idx = 0;
        for(String s : MENUS){
            int x = Utils.getCenterXString(s,gp,g2);
            int y = gp.screenHeight / 2 + (gp.tileSize * (2 + idx));

            g2.drawString(s,x,y);
            g2.drawString(">", x - 42, y);
            idx++;
        }
    }

    public void drawTitleScreen(Graphics2D g2, GamePanel gp){
        this.drawTitle(g2, gp);
        this.drawMenu(g2,gp);
    }
}
