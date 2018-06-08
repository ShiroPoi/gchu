package GUI;

import Game.*;
import Pieces.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;


public class XiangQiGUI {

        Game game;
        Player currPlayer;
        Piece selectedPiece;
        JButton selectedSquare;
        boolean endTurn = false;

        public static void main(String[] args) throws InterruptedException {
            XiangQi inst = new XiangQi();
            inst.gameLoop();
        }


        public synchronized void waitForInput()
        {
            while(!endTurn)
            {
                try{
                    wait();
                } catch (InterruptedException e){ e.printStackTrace();}
            }
        }

        public synchronized  void notifyInput()
        {
            endTurn = true;
            notifyAll();
        }

        public XiangQiGUI() {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JFrame frame = new JFrame("Chinese Chess");
                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    frame.setLayout(new BorderLayout());
                    Window window = new Window();
                    frame.add(window);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
            );
        }

        class MyActionListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e){
                JButton button = (JButton) e.getSource();
                Point rv = new Point();
                Piece selection = game.gameBoard.boardArray[(button.getLocation(rv).x)/100][(button.getLocation(rv).y)/100];

                if(selection == null || (selectedPiece != null && selection.player != selectedPiece.player && selectedPiece.player == currPlayer))
                {
                    if(selectedPiece == null)
                        return;

                    else
                    {
                        selectedPiece.player.myGame.gameBoard.movePiece(selectedPiece, button.getLocation(rv).x / 100, button.getLocation(rv).y / 100);
                        if(game.capture)
                        {
                            button.setIcon(null);
                            Icon img = selectedSquare.getIcon();
                            button.setIcon(img);
                            selectedSquare.setIcon(null);
                        }
                        else if(game.invalid)
                        {
                            JOptionPane.showMessageDialog(null, "Invalid movement! Please try another move.");
                            game.capture = false;
                            selectedSquare = null;
                            selectedPiece = null;
                            game.invalid = false;
                            return;
                        }

                        else
                        {
                            Icon img = selectedSquare.getIcon();
                            button.setIcon(img);
                            selectedSquare.setIcon(null);
                        }

                        game.capture = false;
                        selectedSquare = null;
                        selectedPiece = null;
                        game.invalid = false;
                        notifyInput();


                    }

                }


                else
                {
                    if(selection.player == currPlayer) {
                        selectedPiece = game.gameBoard.boardArray[button.getLocation(rv).x / 100][button.getLocation(rv).y / 100];
                        selectedSquare = button;
                    }
                }


            }
        }

        public class Window extends JPanel {

            public Window() {
                setLayout(new GridBagLayout());

                GridBagConstraints gbc = new GridBagConstraints();

                for (int row = 0; row < 10; row++) {
                    for (int col = 0; col < 9; col++) {
                        gbc.gridx = col;
                        gbc.gridy = row;

                        Border border = null;
                        if (row < 9) {
                            if (col < 8) {
                                border = new MatteBorder(1, 1, 0, 0, java.awt.Color.GRAY);
                            } else {
                                border = new MatteBorder(1, 1, 0, 1, java.awt.Color.GRAY);
                            }
                        } else {
                            if (col < 8) {
                                border = new MatteBorder(1, 1, 1, 0, java.awt.Color.GRAY);
                            } else {
                                border = new MatteBorder(1, 1, 1, 1, java.awt.Color.GRAY);
                            }
                        }
                        JButton button = new JButton();


                        if (row == 3 && (col == 0 || col == 2 || col == 4 || col == 6 || col == 8)) {
                            Image blackPawn = null;
                            try {
                                blackPawn = ImageIO.read(getClass().getResource("Assets/BlackPawn.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(blackPawn));
                        }

                        if (row == 6 && (col == 0 || col == 2 || col == 4 || col == 6 || col == 8)) {
                            Image redPawn = null;
                            try {
                                redPawn = ImageIO.read(getClass().getResource("Assets/RedPawn.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(redPawn));
                        }

                        if (row == 0 && (col == 0 || col == 8)) {
                            Image blackRook = null;
                            try {
                                blackRook = ImageIO.read(getClass().getResource("Assets/BlackRook.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(blackRook));
                        }

                        if (row == 9 && (col == 0 || col == 8)) {
                            Image redRook = null;
                            try {
                                redRook = ImageIO.read(getClass().getResource("Assets/RedRook.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(redRook));
                        }

                        if (row == 0 && (col == 1 || col == 7)) {
                            Image blackKnight = null;
                            try {
                                blackKnight = ImageIO.read(getClass().getResource("Assets/BlackKnight.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(blackKnight));
                        }

                        if (row == 9 && (col == 1 || col == 7)) {
                            Image redKnight = null;
                            try {
                                redKnight = ImageIO.read(getClass().getResource("Assets/RedKnight.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(redKnight));
                        }

                        if (row == 0 && (col == 2 || col == 6)) {
                            Image blackBishop = null;
                            try {
                                blackBishop = ImageIO.read(getClass().getResource("Assets/BlackBishop.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(blackBishop));
                        }

                        if (row == 9 && (col == 2 || col == 6)) {
                            Image redBishop = null;
                            try {
                                redBishop = ImageIO.read(getClass().getResource("Assets/RedBishop.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(redBishop));
                        }

                        if (row == 0 && col == 4) {
                            Image blackKing = null;
                            try {
                                blackKing = ImageIO.read(getClass().getResource("Assets/BlackKing.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(blackKing));
                        }

                        if (row == 9 && col == 4) {
                            Image redKing = null;
                            try {
                                redKing = ImageIO.read(getClass().getResource("Assets/RedKing.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(redKing));
                        }

                        if (row == 0 && (col == 3 || col == 5)) {
                            Image blackAdvisor = null;
                            try {
                                blackAdvisor = ImageIO.read(getClass().getResource("Assets/BlackAdvisor.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(blackAdvisor));
                        }

                        if (row == 9 && (col == 3 || col == 5)) {
                            Image redAdvisor = null;
                            try {
                                redAdvisor = ImageIO.read(getClass().getResource("Assets/RedAdvisor.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(redAdvisor));
                        }

                        if (row == 2 && (col == 1 || col == 7)) {
                            Image blackCannon = null;
                            try {
                                blackCannon = ImageIO.read(getClass().getResource("Assets/BlackCannon.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(blackCannon));
                        }

                        if (row == 7 && (col == 1 || col == 7)) {
                            Image redCannon = null;
                            try {
                                redCannon = ImageIO.read(getClass().getResource("Assets/RedCannon.png"));
                            } catch (IOException e) {
                            }
                            button.setIcon(new ImageIcon(redCannon));
                        }
                        button.setOpaque(false);
                        button.setContentAreaFilled(false);
                        button.setBorderPainted(true);
                        button.setPreferredSize(new Dimension(100, 100));
                        button.setBackground(java.awt.Color.white);
                        MyActionListener mal = new MyActionListener();
                        button.addActionListener(mal);
                        add(button, gbc);
                    }
                }
            }
        }
}
