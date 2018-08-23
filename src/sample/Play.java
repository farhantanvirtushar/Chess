package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.*;

public class Play extends GridPane {
    Data data;
    //Button boardView[][];
    Label you;
    Label pc;
    Play(Data data)
    {
        this.data=data;
        //data.play=this;
        //boardView = new Button[9][9];
        you=new Label("     YOU");
        pc=new Label("   CPU       ");
    }
    void set()
    {
        BackgroundImage backgroundImage = new BackgroundImage(data.playBgImage,BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
        drawBoard();
        updateBoard();
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                data.boardView[i][j].setOnAction(new MoveListener(i,j,this));
            }
        }
        if(data.cpuMove)
        {
            data.pcMakeMove();
            updateBoard();
        }
    }
    void drawBoard()
    {
        int k=1;
        add(pc,0,0);
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                data.boardView[i+1][j+1]=new Button("");
                add(data.boardView[i+1][j+1],j+k,i);
                int a=i+j;
                if((a%2)==0)
                {
                    data.boardView[i+1][j+1].setStyle("-fx-background-color: #ffffff;");
                }
                else
                {
                    data.boardView[i+1][j+1].setStyle("-fx-background-color: #696969;");
                }

                data.boardView[i+1][j+1].setMaxSize((data.squareSIze),(data.squareSIze));
                data.boardView[i+1][j+1].setMinSize((data.squareSIze),(data.squareSIze));
            }
        }
        add(you,9,0);
        you.setTextFill(Color.web("#ffffff"));
        you.setFont(Font.font("Arial", 50));
        pc.setTextFill(Color.web("#ffffff"));
        pc.setFont(Font.font("Arial", 50));
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
                    data.boardView[i][j].setStyle("-fx-background-color: #ffffff;");
                }
                else
                {
                    data.boardView[i][j].setStyle("-fx-background-color: #696969;");
                }


                if(data.chessBoard.board[i][j].equals("pw"))
                {
                    data.boardView[i][j].setGraphic(new ImageView(data.pw));
                }
                else if(data.chessBoard.board[i][j].equals("pb"))
                {
                    data.boardView[i][j].setGraphic(new ImageView(data.pb));
                }
                else if(data.chessBoard.board[i][j].equals("rw"))
                {
                    data.boardView[i][j].setGraphic(new ImageView(data.rw));
                }
                else if(data.chessBoard.board[i][j].equals("rb"))
                {
                    data.boardView[i][j].setGraphic(new ImageView(data.rb));
                }
                else if(data.chessBoard.board[i][j].equals("nw"))
                {
                    data.boardView[i][j].setGraphic(new ImageView(data.nw));
                }
                else if(data.chessBoard.board[i][j].equals("nb"))
                {
                    data.boardView[i][j].setGraphic(new ImageView(data.nb));
                }
                else if(data.chessBoard.board[i][j].equals("bw"))
                {
                    data.boardView[i][j].setGraphic(new ImageView(data.bw));
                }
                else if(data.chessBoard.board[i][j].equals("bb"))
                {
                    data.boardView[i][j].setGraphic(new ImageView(data.bb));
                }
                else if(data.chessBoard.board[i][j].equals("qw"))
                {
                    data.boardView[i][j].setGraphic(new ImageView(data.qw));
                }
                else if(data.chessBoard.board[i][j].equals("qb"))
                {
                    data.boardView[i][j].setGraphic(new ImageView(data.qb));
                }
                else if(data.chessBoard.board[i][j].equals("kw"))
                {
                    data.boardView[i][j].setGraphic(new ImageView(data.kw));
                }
                else if(data.chessBoard.board[i][j].equals("kb"))
                {
                    data.boardView[i][j].setGraphic(new ImageView(data.kb));
                }
                else if(data.chessBoard.board[i][j].equals("##"))
                {
                    data.boardView[i][j].setGraphic(new ImageView());
                }
            }
        }
    }

}
