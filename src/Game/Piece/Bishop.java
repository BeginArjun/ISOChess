package Game.Piece;

import Util.Position;

public class Bishop extends Piece{
    String lightImgFront, darkImgFront;

    public Bishop(String title, int x, int y) {
        super(title, new Position(x,y));
        if(this.type == Type.DARK){
            this.darkImgFront = "/Pieces/bishop-dark.png";
            setImages(this.darkImgFront);
        }else{
            this.lightImgFront = "/Pieces/bishop-light.png";
            setImages(this.lightImgFront);
        }
    }
}
