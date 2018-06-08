package Pieces;

import Game.*;

public class King extends Piece {

    Type type;

    public King(int x, int y, Player player){
        super(x, y, player);
        type = Type.KING;
    }

    public Type getType(){
        return Type.KING;
    }

    public boolean isValidPath(int finalX, int finalY) {
        int xDiff = Math.abs(finalX - this.x);
        int yDiff = Math.abs(finalY - this.y);
        if (xDiff + yDiff == 1) {
            if (this.player.playerColor == Color.RED) { //RED IS BOTTOM OF BOARD
                return (finalX == 3 && finalY == 7) || (finalX == 4 && finalY == 7) || (finalX == 5 && finalY == 7) ||
                        (finalX == 3 && finalY == 8) || (finalX == 4 && finalY == 8) || (finalX == 5 && finalY == 8) ||
                        (finalX == 3 && finalY == 9) || (finalX == 4 && finalY == 9) || (finalX == 5 && finalY == 9);
            } else {
                return (finalX == 3 && finalY == 1) || (finalX == 4 && finalY == 1) || (finalX == 5 && finalY == 1) ||
                        (finalX == 3 && finalY == 2) || (finalX == 4 && finalY == 2) || (finalX == 5 && finalY == 2) ||
                        (finalX == 3 && finalY == 0) || (finalX == 4 && finalY == 0) || (finalX == 5 && finalY == 0);
            }
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
