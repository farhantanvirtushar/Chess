package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.net.URL;

public class Data{
    Stage window;
    URL url;
    final int WHITE=1;
    final int BLACK=2;
    int player;
    int pc;
    boolean cpuMove;
    double maxWidth;
    double maxHeight;
    double squareSIze;
    Button boardView[][];
    Cell move1,move2;
    CountLegalMoves countLegalMoves;
    LegalMoves2 legalMoves2;
    Cell nextPossibleMoves[];
    Play play;

    Image bgImage;
    Image playBgImage;
    Image playAsWhite;
    Image playAsBlack;
    Image pw,pb,rw,rb,nw,nb,bw,bb,qw,qb,kw,kb;
    ChessBoard chessBoard;

    CastlingChecker cstChecker;
    boolean gameOver;
    boolean wKingFree,bKingFree;

    final int GAME_TREE_HEIGHT = 5;
    ComputerMoveGenerator computerMoveGenerator;
    char cpuColor;
    char playerColor;
    int moveCount;
    Data(Stage stage)
    {
        play = new Play(this);
        player = 0;
        pc =0;
        moveCount=0;
        gameOver = false;
        cstChecker = new CastlingChecker();
        wKingFree=true;
        bKingFree=true;
        window = stage;
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        maxHeight = primaryScreenBounds.getHeight();
        maxWidth = primaryScreenBounds.getWidth();
        squareSIze = (maxHeight/8.5);

        boardView = new Button[9][9];


        url = getClass().getResource("/images/");
        bgImage = new Image(url+"menuBackground.jpg",maxWidth,maxHeight,true,true);
        playBgImage = new Image(url+"gameBackground.jpg",maxWidth,maxHeight,true,true);
        playAsBlack = new Image(url+"playAsBlack.png",200,100,true,true);
        playAsWhite= new Image(url+"playAsWhite.png",200,100,true,true);
        pw = new Image(url+"pw.png",squareSIze,squareSIze,true,true);
        pb = new Image(url+"pb.png",squareSIze,squareSIze,true,true);
        rw = new Image(url+"rw.png",squareSIze,squareSIze,true,true);
        rb = new Image(url+"rb.png",squareSIze,squareSIze,true,true);
        nw = new Image(url+"nw.png",squareSIze,squareSIze,true,true);
        nb = new Image(url+"nb.png",squareSIze,squareSIze,true,true);
        bw = new Image(url+"bw.png",squareSIze,squareSIze,true,true);
        bb = new Image(url+"bb.png",squareSIze,squareSIze,true,true);
        qw = new Image(url+"qw.png",squareSIze,squareSIze,true,true);
        qb = new Image(url+"qb.png",squareSIze,squareSIze,true,true);
        kw = new Image(url+"kw.png",squareSIze,squareSIze,true,true);
        kb = new Image(url+"kb.png",squareSIze,squareSIze,true,true);

        countLegalMoves = new CountLegalMoves(this);
        legalMoves2 = new LegalMoves2(this);
        computerMoveGenerator = new ComputerMoveGenerator(this);
    }
    void setPlayerWhite()
    {
        player=WHITE;
        pc=BLACK;
        cpuColor = 'b';
        playerColor = 'w';
        cpuMove=false;
        chessBoard = new ChessBoard(this);
        window.setScene(new Scene(play));
        play.set();
    }
    void setPlayerBlack()
    {
        player=BLACK;
        pc=WHITE;
        cpuColor = 'w';
        playerColor = 'b';
        cpuMove = true;
        chessBoard = new ChessBoard(this);
        window.setScene(new Scene(play));
        play.set();
    }
    void move(Cell cell)
    {
        if(move1 == null)
        {
            move1 = cell;
            nextPossibleMoves = countLegalMoves.legalMoves(move1.row,move1.column,chessBoard.board,cstChecker);
            for(int i=0;i<30;i++)
            {
                if(nextPossibleMoves[i]!=null)
                {
                    int r=nextPossibleMoves[i].row;
                    int c=nextPossibleMoves[i].column;
                    if((r+c)%2==0)
                    {
                        boardView[r][c].setStyle("-fx-background-color: #69ff69;");
                    }
                    else
                    {
                        boardView[r][c].setStyle("-fx-background-color: #005500;");
                    }
                }
            }
            return ;
        }
        move2 = cell;
        makeMove();
        nextPossibleMoves = null;
    }
    void makeMove()
    {
        int counter = 0;
        for (int i=0;i<30;i++)
        {
            if(nextPossibleMoves[i] != null)
            {
                if(nextPossibleMoves[i].equals(move2))
                {
                    counter++;
                    if(chessBoard.board[move2.row][move2.column].charAt(0)=='k')
                    {
                        gameOver = true;
                        showGameOverWindow();
                    }
                    String temp = chessBoard.board[move1.row][move1.column];
                    if(temp.charAt(0)=='k')
                    {
                        if(temp.charAt(1)=='w')
                        {
                            cstChecker.kwNotMoved = false;
                        }
                        else if(temp.charAt(1)=='b')
                        {
                            cstChecker.kbNotMoved=false;
                        }
                        if((Math.abs(move1.column - move2.column))==2)
                        {
                            if(move2.column == 7)
                            {
                                String t;
                                t=chessBoard.board[move1.row][6];
                                chessBoard.board[move1.row][6] = chessBoard.board[move1.row][8];
                                chessBoard.board[move1.row][8]=t;
                            }
                            else if (move2.column == 3)
                            {
                                String t;
                                t=chessBoard.board[move1.row][4];
                                chessBoard.board[move1.row][4] = chessBoard.board[move1.row][1];
                                chessBoard.board[move1.row][1]=t;
                            }
                            else if (move2.column == 2)
                            {
                                String t;
                                t=chessBoard.board[move1.row][3];
                                chessBoard.board[move1.row][3] = chessBoard.board[move1.row][1];
                                chessBoard.board[move1.row][1]=t;
                            }
                            else if (move2.column == 6)
                            {
                                String t;
                                t=chessBoard.board[move1.row][5];
                                chessBoard.board[move1.row][5] = chessBoard.board[move1.row][8];
                                chessBoard.board[move1.row][8]=t;
                            }
                        }
                    }
                    else if(temp.charAt(0)=='r')
                    {
                        if(temp.charAt(1)=='w')
                        {
                            if(move1.column == 1)
                            {
                                cstChecker.rw1NotMoved=false;
                            }
                            else if(move1.column == 8)
                            {
                                cstChecker.rw2NotMoved=false;
                            }
                        }
                        else if(temp.charAt(1)=='b')
                        {
                            if(move1.column == 1)
                            {
                                cstChecker.rb1NotMoved=false;
                            }
                            else if(move1.column == 8)
                            {
                                cstChecker.rb2NotMoved=false;
                            }
                        }
                    }
                    chessBoard.board[move2.row][move2.column] = temp;
                    chessBoard.board[move1.row][move1.column] = "##";
                    if(((move2.row == 1)||(move2.row == 8))&&(chessBoard.board[move2.row][move2.column].charAt(0) =='p'))
                    {
                        if(chessBoard.board[move2.row][move2.column].charAt(1) =='w')
                        {
                            chessBoard.board[move2.row][move2.column] = "qw";
                        }
                        else if(chessBoard.board[move2.row][move2.column].charAt(1) =='b')
                        {
                            chessBoard.board[move2.row][move2.column] = "qb";
                        }
                    }

                    break;
                }
            }
        }
        if(counter == 0)
        {
            updateBoard();
            move1=null;
            move2=null;
            cpuMove = false;
            return ;
        }
        updateBoard();
        move1=null;
        move2=null;
        cpuMove = true;
    }

    void pcMakeMove()
    {
        String nextBoard[][] = computerMoveGenerator.findBestMove(chessBoard.board,cstChecker.copy(),0);
        cpuMove=false;
        //System.out.println(moveCount);
        //moveCount=0;
        int counter=0;
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                chessBoard.board[i][j]=nextBoard[i][j];
                if(chessBoard.board[i][j].charAt(0)=='k')
                {
                    counter++;
                }
            }
        }
        if(counter<2)
        {
            gameOver=true;
            showGameOverWindow();

        }
        updateBoard();
    }
    void updateBoard()
    {
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                int a=i+j;

                if((a%2)==0)
                {
                    boardView[i][j].setStyle("-fx-background-color: #ffffff;");
                }
                else
                {
                    boardView[i][j].setStyle("-fx-background-color: #696969;");
                }


                if(chessBoard.board[i][j].equals("pw"))
                {
                    boardView[i][j].setGraphic(new ImageView(pw));
                }
                else if(chessBoard.board[i][j].equals("pb"))
                {
                    boardView[i][j].setGraphic(new ImageView(pb));
                }
                else if(chessBoard.board[i][j].equals("rw"))
                {
                    boardView[i][j].setGraphic(new ImageView(rw));
                }
                else if(chessBoard.board[i][j].equals("rb"))
                {
                    boardView[i][j].setGraphic(new ImageView(rb));
                }
                else if(chessBoard.board[i][j].equals("nw"))
                {
                    boardView[i][j].setGraphic(new ImageView(nw));
                }
                else if(chessBoard.board[i][j].equals("nb"))
                {
                    boardView[i][j].setGraphic(new ImageView(nb));
                }
                else if(chessBoard.board[i][j].equals("bw"))
                {
                    boardView[i][j].setGraphic(new ImageView(bw));
                }
                else if(chessBoard.board[i][j].equals("bb"))
                {
                    boardView[i][j].setGraphic(new ImageView(bb));
                }
                else if(chessBoard.board[i][j].equals("qw"))
                {
                    boardView[i][j].setGraphic(new ImageView(qw));
                }
                else if(chessBoard.board[i][j].equals("qb"))
                {
                    boardView[i][j].setGraphic(new ImageView(qb));
                }
                else if(chessBoard.board[i][j].equals("kw"))
                {
                    boardView[i][j].setGraphic(new ImageView(kw));
                }
                else if(chessBoard.board[i][j].equals("kb"))
                {
                    boardView[i][j].setGraphic(new ImageView(kb));
                }
                else if(chessBoard.board[i][j].equals("##"))
                {
                    boardView[i][j].setGraphic(new ImageView());
                }
            }
        }
    }
    void showGameOverWindow()
    {
        Stage finish = new Stage();
        finish.setScene(new Scene(new GameOverWindow()));
        finish.show();
    }

}