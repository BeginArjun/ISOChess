package Game.Piece;

import Util.Position;

public interface AbstractPiece {
    public void move(Position currentPos);
    public Position getCurrentPosition();
}
