package Game.Piece;

import Constants.Constants;
import Main.GamePanel;
import Util.Position;
import Util.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;


public class Piece implements AbstractPiece {
    ArrayList<BufferedImage> images;
    String title;
    Position pos;
    public Type type;
    public enum Type{
        DARK,
        LIGHT
    }

    public Piece(String title, Position pos){
        this.title = title;
        this.images = new ArrayList<>(4);
        this.pos = pos;

        if(pos.x > 1){
            this.type = Type.DARK;
        }else{
            this.type = Type.LIGHT;
        }
    }


    public ArrayList<BufferedImage> getImages() {
        return images;
    }

    public void setImages(String path){
        try{
            if(this.images.size() > 4) throw new Exception("Overflow! No more images can be added");
            this.images.add(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g, int row, int col){
        Position placement = Position.getIsometricPosition(row,col);
        g.drawImage(this.images.getFirst(),placement.x, placement.y, Constants.tileSize, Constants.tileSize, null);
    }

    @Override
    public void move(Position currentPos) {
        // Do something
    }

    @Override
    public Position getCurrentPosition() {
        return this.pos;
    }
}
