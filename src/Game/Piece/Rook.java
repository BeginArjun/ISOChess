package Game.Piece;

import Util.Position;

public class Rook extends Piece{
    String lightImgFront, darkImgFront;

    public Rook(String title, int x, int y) {
        super(title, new Position(x,y));
        if(this.type == Type.DARK){
            this.darkImgFront = "/Pieces/rook-dark.png";
            setImages(this.darkImgFront);
        }else{
            this.lightImgFront = "/Pieces/rook-light.png";
            setImages(this.lightImgFront);
        }
    }
}
