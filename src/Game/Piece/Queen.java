package Game.Piece;

import Util.Position;

public class Queen extends Piece{
    String lightImgFront, darkImgFront;

    public Queen(String title, int x, int y) {
        super(title, new Position(x, y));
        if(this.type == Type.DARK){
            this.darkImgFront = "/Pieces/queen-dark.png";
            setImages(this.darkImgFront);
        }else{
            this.lightImgFront = "/Pieces/queen-light.png";
            setImages(this.lightImgFront);
        }
    }
}
