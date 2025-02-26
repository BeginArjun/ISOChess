package Game;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Board {
    public final int COL = 8;
    public final int ROW = 8;

    public BufferedImage darkTile;
    public BufferedImage lightTile;

    public Board(){
        try{
            this.darkTile = ImageIO.read(getClass().getResourceAsStream("/Board/DarkBox.png"));
            this.lightTile = ImageIO.read(getClass().getResourceAsStream("/Board/LightBox.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateBoard(Graphics2D g, GamePanel gp){
        int startX = (gp.screenWidth /2) - (gp.tileSize / 2);
        int startY = (gp.screenHeight / 4) - (gp.tileSize / 2);
        for(int row = 0; row < ROW; row++){
            for(int col = 0; col < COL; col++){
                BufferedImage tileImage = (row + col) % 2 == 0 ? lightTile : darkTile;
                int x = startX + (col - row) * (gp.tileSize / 2);
                int y = startY + (col + row) * (gp.tileSize / 4);
                g.drawImage(tileImage, x, y, gp.tileSize, gp.tileSize, null);
            }
        }
    }
}
