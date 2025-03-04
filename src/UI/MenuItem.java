package UI;

import Constants.Constants;
import Util.Utils;

import java.awt.*;

public class MenuItem {
    Rectangle bound;
    String title;
    private boolean active;
    private static final int PADDING = 20;
    Point textPosition;

    public MenuItem(String title,int x, int y, boolean active, Graphics2D g){
        this.title = title;
        this.active = active;
        this.bound = Utils.calculateBound(title,x,y,g,PADDING);
        this.textPosition = Utils.getCenteredTextPosition(title,this.bound,g);
    }

    public MenuItem(String title,int x, int y, Graphics2D g){
        this.title = title;
        this.active = false;
        this.bound = Utils.calculateBound(title,x, y,g,PADDING);
        this.textPosition = Utils.getCenteredTextPosition(title,this.bound,g);
    }

    public void draw(Graphics2D g){
        g.setFont(Constants.menuFont);
        g.setColor(Color.WHITE);
        if(this.active){
            g.draw(bound);
        }
        g.drawString(this.title, textPosition.x, textPosition.y);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
