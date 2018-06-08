package Pieces;

import Game.*;

public class Bishop extends Piece{

    Type type;

    public Bishop(int x, int y, Player player){
        super(x,y,player);
        type = Type.BISHOP;
    }

    public Type getType(){
        return Type.BISHOP;
    }

    public boolean isValidPath(int finalX, int finalY){

        int xDiff = Math.abs(finalX - this.x);
        int yDiff = Math.abs(finalY - this.y);
        if (this.player.playerColor == Color.RED) {
            if (finalY >= 5){
                half = true;
            }
        }
        else {
            if (finalY <= 4) {
                half = true;
            }
        }
        return xDiff == yDiff && half;
    }

    public int[][] drawPath(int startX, int startY, int finalX, int finalY){
        int pairs = Math.abs(finalX - startX);
        int xDir = 1, yDir = 1;
        if (finalX - startX < 0) xDir = -1;
        if (finalY - startY < 0) yDir = -1;

        int[][] path = new int [2][pairs-1];
        if (pairs - 1 > 0){
            for (int i = 0; i < path[0].length; i++){
                path[0][i] = startX + xDir*i;
                path[1][i] = startY + yDir*i;
            }
        }

        return path;
    }
}
