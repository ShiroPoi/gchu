package Pieces;

import Game.*;

public class Advisor extends Piece{

    Type type;

    public Advisor(int x, int y, Player player){
        super(x,y,player);
        type = Type.ADVISOR;
    }

    public Type getType(){
        return Type.ADVISOR;
    }

    public boolean isValidPath(int finalX, int finalY){
        if (this.player.playerColor == Color.RED) {
            if (this.y == 9 && this.x == 3 && finalY == 8 && finalX == 4) return true;
            if (this.y == 9 && this.x == 5 && finalY == 8 && finalX == 4) return true;
            if (this.y == 8 && this.x == 4 && finalY == 9 && finalX == 3) return true;
            if (this.y == 8 && this.x == 4 && finalY == 9 && finalX == 5) return true;
            if (this.y == 8 && this.x == 4 && finalY == 7 && finalX == 3) return true;
            if (this.y == 8 && this.x == 4 && finalY == 7 && finalX == 5) return true;
            if (this.y == 7 && this.x == 3 && finalY == 8 && finalX == 4) return true;
            if (this.y == 7 && this.x == 5 && finalY == 8 && finalX == 4) return true;
        }
        else {
            if (this.y == 0 && this.x == 3 && finalY == 1 && finalX == 4) return true;
            if (this.y == 0 && this.x == 5 && finalY == 1 && finalX == 4) return true;
            if (this.y == 1 && this.x == 4 && finalY == 0 && finalX == 3) return true;
            if (this.y == 1 && this.x == 4 && finalY == 0 && finalX == 5) return true;
            if (this.y == 1 && this.x == 4 && finalY == 2 && finalX == 3) return true;
            if (this.y == 1 && this.x == 4 && finalY == 2 && finalX == 5) return true;
            if (this.y == 2 && this.x == 3 && finalY == 1 && finalX == 4) return true;
            if (this.y == 2 && this.x == 5 && finalY == 1 && finalX == 4) return true;
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
