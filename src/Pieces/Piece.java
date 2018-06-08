package Pieces;

import Game.*;

public abstract class Piece {

    public int x, y;
    public Player player;
    public boolean half;

    public Piece(int x, int y, Player player)
    {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public abstract boolean isValidPath(int finalX, int finalY);

    public abstract int[][] drawPath(int startX, int startY, int finalX, int finalY);

    public abstract Type getType();
}
