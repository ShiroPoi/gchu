package Pieces;

import Game.*;

public class Knight extends Piece{

    Type type;

    public Knight(int x, int y, Player player){
        super(x, y, player);
        type = Type.KNIGHT;
    }

    public Type getType(){
        return Type.KNIGHT;
    }

    public boolean isValidPath(int finalX, int finalY){
        int xDiff = Math.abs(finalX - this.x);
        int yDiff = Math.abs(finalY - this.y);
        return xDiff + yDiff == 3;
    }

    public int [][] drawPath(int startX, int startY, int finalX, int finalY)
    {
        int pairs = 0;
        int [][] path = new int[2][pairs];

        return path;
    }
}
