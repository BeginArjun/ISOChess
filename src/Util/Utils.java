package Util;

import Main.GamePanel;

import java.awt.*;

public class Utils {

    public static int screenWidth = 0;
    public static int screenHeight = 0;

    public static int getCenterXString(String text, GamePanel gp, Graphics2D g2){
        int textLenght;
        textLenght = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth(); // Gets width of text.
        int x = gp.screenWidth / 2 - textLenght/2;
        return x;
    }
}
