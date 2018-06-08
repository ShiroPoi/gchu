package Game;

import Exceptions.InvalidMovementException;
import Pieces.*;
import java.util.Vector;

public class Board {

    public int height, width;
    public Piece[][] boardArray;
    public Game game;
    public Vector<Piece> redPieces = new Vector<Piece>(16);
    public Vector<Piece> blackPieces = new Vector<Piece>(16);

    public Board(int height, int width, Game game) {
        this.height = height;
        this.width = width;
        boardArray = new Piece[height][width];
        this.game = game;
    }

    public void setPieces() {
        setPlayer1Pieces();
        setPlayer2Pieces();
        setPieceVectors();
    }

    public void setPlayer2Pieces() {
        Piece[][] board = this.boardArray;

        for (int i = 0; i < 9; i = i + 2) {
            Piece pawn = new Pawn(i, 3, this.game.player2);
        }

        Piece rook1 = new Rook(0, 0, this.game.player2);
        Piece rook2 = new Rook(8, 0, this.game.player2);

        Piece knight1 = new Knight(1, 0, this.game.player2);
        Piece knight2 = new Knight(7, 0, this.game.player2);

        Piece bishop1 = new Bishop(2, 0, this.game.player2);
        Piece bishop2 = new Bishop(6, 0, this.game.player2);

        Piece advisor1 = new Advisor(3, 0, this.game.player2);
        Piece advisor2 = new Advisor(5, 0, this.game.player2);

        Piece cannon1 = new Cannon(1, 2, this.game.player2);
        Piece cannon2 = new Cannon(7, 2, this.game.player2);

        King king = new King(4, 0, this.game.player2);
    }

    public void setPlayer1Pieces() {
        Piece[][] board = this.boardArray;

        for (int i = 0; i < 9; i = i + 2) {
            Piece pawn = new Pawn(i, 6, this.game.player1);
        }

        Piece rook3 = new Rook(0, 9, this.game.player1);
        Piece rook4 = new Rook(8, 9, this.game.player1);

        Piece knight3 = new Knight(1, 9, this.game.player1);
        Piece knight4 = new Knight(7, 9, this.game.player1);

        Piece bishop3 = new Bishop(1, 9, this.game.player1);
        Piece bishop4 = new Bishop(7, 9, this.game.player1);

        Piece advisor3 = new Advisor(3, 9, this.game.player1);
        Piece advisor4 = new Advisor(5, 9, this.game.player1);

        Piece cannon3 = new Cannon(1, 7, this.game.player1);
        Piece cannon4 = new Cannon(7, 7, this.game.player1);

        King king = new King(4, 9, this.game.player1);
    }

    public void setPieceVectors() {
        for (int i = 0; i < 9; i++) {
            redPieces.add(this.boardArray[i][8]);
            blackPieces.add(this.boardArray[i][0]);
        }
    }

    public void movePiece(Piece piece, int finalX, int finalY) {
        if (isValidMove(piece, finalX, finalY) && piece.isValidPath(finalX, finalY)) {
            if (isCapture(piece, finalX, finalY)) {
                game.capture = true;
                boardArray[finalX][finalY] = null;
            }

            setNewPieceLocation(piece, finalX, finalY);


        } else {
            try {
                throw new InvalidMovementException();
            } catch (InvalidMovementException e) {
                e.printStackTrace();
                game.invalid = true;
            }

            return;
        }
    }

        public boolean isValidMove (Piece piece,int finalX, int finalY)
        {
            int[][] path = piece.drawPath(piece.x, piece.y, finalX, finalY);

            if (isWithinBounds(finalX, finalY) && (validLeaping(piece, path)) && (isNotOrigin(piece, finalX, finalY))
                    && (isValidEndPoint(piece, finalX, finalY))) {
                return true;
            }

            return false;
        }

        protected boolean isWithinBounds ( int finalX, int finalY)
        {
            if ((0 <= finalX && finalX < width) && (0 <= finalY && finalY < height))
                return true;

            return false;
        }

        protected boolean validLeaping (Piece piece,int[][] movePath)
        {
            if (piece.getType() == Type.KNIGHT) //knights can leap
                return true;

            //pawns only have a path under special circumstances. kings will never have a path
            if (piece.getType() == Type.PAWN || piece.getType() == Type.KING)
                return true;

            int pairs = movePath[0].length;

            for (int i = 0; i < pairs - 1; i++) {
                if (boardArray[movePath[0][i]][movePath[1][i]] != null) {
                    return false;
                }
            }

            return true;
        }

        protected boolean isNotOrigin (Piece piece,int finalX, int finalY)
        {
            if ((piece.x != finalX) || (piece.y != finalY))
                return true;

            else {
                return false;
            }

        }

        protected boolean isValidEndPoint (Piece piece,int finalX, int finalY)
        {
            if ((boardArray[finalX][finalY] == null) || ((boardArray[finalX][finalY] != null)
                    && boardArray[finalX][finalY].player.playerColor != piece.player.playerColor)) {
                return true;
            }

            return false;
        }

        public boolean isCapture (Piece piece,int finalX, int finalY)
        {

            if (boardArray[finalX][finalY] != null && boardArray[finalX][finalY].player != piece.player) {
                if (boardArray[finalX][finalY].getType() == Type.KING)
                    boardArray[finalX][finalY].player.isLoser = true;
                return true;
            } else
                return false;
        }

        public void setNewPieceLocation (Piece piece,int finalX, int finalY)
        {
            int originX = piece.x;
            int originY = piece.y;

            piece.x = finalX; //set piece's new location
            piece.y = finalY;

            boardArray[finalX][finalY] = piece; //set array to new piece's position
            boardArray[originX][originY] = null; //set starting point to empty
        }
    }


