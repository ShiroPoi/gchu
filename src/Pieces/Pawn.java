package Pieces;

import Game.*;

public class Pawn extends Piece{

    Type type;

    public Pawn(int x, int y, Player player){
        super(x, y, player);
        type = Type.PAWN;
        half = false;
    }

    public Type getType(){
        return Type.PAWN;
    }

    public boolean isValidPath(int finalX, int finalY){
        if (this.player.playerColor == Color.RED) { //RED IS BOTTOM OF BOARD
            if (y >= 5){
                half = true;
            }
        }
        else {
            if (y <= 4) {
                half = true;
            }
        }
        if (half){
            return (finalX - x ==1)&&(finalY == y);
        }
        else if (finalY - y >= 0){
            return (Math.abs(finalX - x)+(finalY - y)==1);
        }
        return false;
    }

    public int [][] drawPath(int startX, int startY, int finalX, int finalY)
    {
        int pairs = 0;
        int [][] path = new int[2][pairs];

        return path;
    }
}
