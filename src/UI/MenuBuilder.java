package UI;

import Constants.Constants;
import Main.KeyHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuBuilder {
    MenuItems menuItems;

    public MenuBuilder(String[] menus, KeyHandler keyH, Graphics2D g){
        this.menuItems = new MenuItems(menus,g);
    }
}
