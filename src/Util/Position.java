package Util;

import Constants.Constants;

public class Position{
    public int x, y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Copy Constructor
    public Position(Position copy){
        this.x = copy.x;
        this.y = copy.y;
    }

    public static Position getIsometricPosition(int row, int col){
        int startX = (Constants.screenWidth / 2) - (Constants.tileSize / 2);
        int startY = (Constants.screenHeight / 4) - (Constants.tileSize);

        int x = (startX + (col - row) * (Constants.tileSize / 2));
        int y = (startY + (col + row) * (Constants.tileSize / 4));



        return new Position(x, y);
    }
}
