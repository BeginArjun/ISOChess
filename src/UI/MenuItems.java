package UI;

import Constants.Constants;
import Util.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuItems{
    ArrayList<MenuItem> menuItems;

    private void setItems(String[] items, Graphics2D g){
        int y = Constants.screenHeight / (items.length + 1);
        for (int i = 0; i < items.length; i++) {
            String s = items[i];

            int x = Utils.getCenterXString(s, g);
            y+= Constants.tileSize;

            MenuItem item = new MenuItem(s,x,y,i == 0,g);
            assert menuItems != null;
            menuItems.add(item);
        }
    }

    public MenuItems(String[] items, Graphics2D g){
        this.menuItems = new ArrayList<>(items.length);
        this.setItems(items,g);
        this.draw(g);
    }

    public void draw(Graphics2D g){
        for(MenuItem item : menuItems){
            item.draw(g);
        }
    }
}
