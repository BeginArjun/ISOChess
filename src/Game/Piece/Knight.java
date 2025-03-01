package Game.Piece;

import Util.Position;

public class Knight extends Piece{
    String lightImgFront, darkImgFront;

    public Knight(String title, int x, int y) {
        super(title, new Position(x,y));
        if(this.type == Type.DARK){
            this.darkImgFront = "/Pieces/knight-dark-rev.png";
            setImages(this.darkImgFront);
        }else{
            this.lightImgFront = "/Pieces/knight-light.png";
            setImages(this.lightImgFront);
        }
    }
}
