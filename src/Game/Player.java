package Game;
import Pieces.*;

import java.util.Vector;

public class Player {

    public Color playerColor;
    public boolean goesFirst;
    public boolean isLoser = false;
    public Game myGame;
    public boolean isTurn = false;
    public int score = 0;


    public Player(Color playerColor)
    {
        this.playerColor = playerColor;
    }

    public Vector<Piece> getAllyPieces(Color playerColor)
    {
        Vector<Piece> allyPieces;

        if(playerColor == Color.RED)
            allyPieces = myGame.gameBoard.redPieces;

        else
            allyPieces = myGame.gameBoard.blackPieces;

        return allyPieces;
    }

    public Vector<Piece> getEnemyPieces(Color playerColor)
    {
        Vector<Piece> enemyPieces;

        if(playerColor == Color.RED)
            enemyPieces = myGame.gameBoard.blackPieces;

        else
            enemyPieces = myGame.gameBoard.redPieces;

        return enemyPieces;

    }
}
