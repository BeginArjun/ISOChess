package UI;

import javax.swing.*;
import java.awt.*;

public class MenuItems{
    Font menuFont = new Font("Arial", Font.PLAIN, 64);
    Font indicatorFont = new Font("Arial", Font.PLAIN, 32);
    String title;

    public MenuItems(String title){
        this.title = title;
    }

    public void drawMenuItem(Graphics2D g2, int x, int y){
        g2.setFont(menuFont);
        g2.setColor(Color.white);
        g2.drawString(this.title, x, y);
        g2.setColor(Color.YELLOW);
        g2.setFont(indicatorFont);
        // DRAW INDICATOR
        g2.drawString(">", x - 32, y);
    }
}
