package Game.Piece;

import Util.Position;

public class King extends Piece{
    String lightImgFront, darkImgFront;

    public King(String title, int x, int y) {
        super(title, new Position(x,y));
        if(this.type == Type.DARK){
            this.darkImgFront = "/Pieces/king-dark.png";
            setImages(this.darkImgFront);
        }else{
            this.lightImgFront = "/Pieces/king-light.png";
            setImages(this.lightImgFront);
        }
    }
}
