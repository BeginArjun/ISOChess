package Game.Piece;

import Main.GamePanel;
import Util.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pawn extends Piece{
    String lightImgFront, darkImgFront;

    public Pawn(String title, int x, int y) {
        super(title, new Position(x, y));
        this.lightImgFront = "/Pieces/pawn-light.png";
        this.darkImgFront = "/Pieces/pawn-dark.png";
        if(this.type == Type.DARK){
            setImages(this.darkImgFront);
        }else{
            setImages(this.lightImgFront);
        }
    }
}
