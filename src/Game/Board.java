package Game;

import Game.Piece.*;
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


        Rook r1 = new Rook("Rook00",0,0);
        r1.draw(g,0,0);

        Knight k1 = new Knight("Knight01",0,1);
        k1.draw(g,0,1);

        Bishop bp1 = new Bishop("Bishop02", 0 , 2);
        bp1.draw(g,0,2);


        for(int col = 0; col < COL; col++){
            Pawn p = new Pawn(String.format("Pawn%d%d",1,col),1,col);
            Pawn dp = new Pawn(String.format("Pawn%d%d",6,col),6,col);
            p.draw(g,1,col);
            dp.draw(g,6,col);
        }
        Rook r2 = new Rook("Rook70",7,0);
        r2.draw(g,7,0);
        Knight k2 = new Knight("Knight71",7,1);
        k2.draw(g,7,1);
        Bishop bp2 = new Bishop("Bishop72",7,2);
        bp2.draw(g,7,2);
    }
}
