package Game;

public class Game {

    public Board gameBoard;
    public Player player1, player2; //for now, player 1 is white, player 2 is black
    public int turn;
    final static int standardHeight = 10, standardWidth = 10;
    public boolean invalid = false, capture = false;

    public Game()
    {
        setStandardGame();
    }

    public void setStandardGame()
    {
        gameBoard = new Board(standardHeight,standardWidth, this);
        setPlayers();
        gameBoard.setPieces();
        turn = 1;
    }

    public void setPlayers()
    {
        player1 = new Player(Color.RED);
        player1.goesFirst = true;
        player2 = new Player(Color.BLACK);
        player2.goesFirst = false;
        player1.myGame = this;
        player2.myGame = this;
    }
}
