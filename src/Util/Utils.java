package Util;

import Constants.Constants;


import java.awt.*;

public class Utils {

    public static int getStringLength(String text, Graphics2D g2){
        int textLength;
        textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        return textLength;
    }

    public static int getCenterXString(String text, Graphics2D g2){
        int textLength = Utils.getStringLength(text,g2);
        return Constants.screenWidth / 2 - textLength/2;
    }

    // Centered Text inside a Rectangle
    public static Point getCenteredTextPosition(String text, Rectangle bound, Graphics2D g){
        FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
        int totalWidth = fontMetrics.stringWidth(text);
        int textX = bound.x + (bound.width - totalWidth / 2) / 2;
        int textY = bound.y + (bound.height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        return new Point(textX , textY);
    }

    public static Rectangle calculateBound(String text, int x, int y, Graphics2D g, int PADDING){
        FontMetrics fontMetrics = g.getFontMetrics(Constants.menuFont);
        int width = Utils.getStringLength(text,g) + (PADDING * 2);
        int height = fontMetrics.getHeight() + (PADDING * 2);


        return new Rectangle(x ,y ,width,height);
    }
}
