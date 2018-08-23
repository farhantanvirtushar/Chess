package sample;

public class ChessBoard{
    String board[][];
    Data data;
    ChessBoard(Data data)
    {
        this.data=data;
       board = new String[9][9];
       for(int i=0;i<9;i++)
       {
           for(int j=0;j<9;j++)
           {
               if((i==0)||(j==0))
               {
                   board[i][j]=" ";
               }
               else
               {
                   board[i][j]="##";
               }
           }
       }
        for(int j=1;j<9;j++)
        {
            if(data.player == data.WHITE)
            {
                board[2][j]="pb";
                board[7][j]="pw";
            }
            else
            {
                board[2][j]="pw";
                board[7][j]="pb";
            }
        }
        if(data.player == data.WHITE)
        {
            board[1][1]="rb";
            board[1][8]="rb";
            board[8][1]="rw";
            board[8][8]="rw";

            board[1][2]="nb";
            board[1][7]="nb";
            board[8][2]="nw";
            board[8][7]="nw";

            board[1][3]="bb";
            board[1][6]="bb";
            board[8][3]="bw";
            board[8][6]="bw";

            board[1][4]="qb";
            board[1][5]="kb";
            board[8][4]="qw";
            board[8][5]="kw";
        }
        else if(data.player == data.BLACK)
        {
            board[1][1]="rw";
            board[1][8]="rw";
            board[8][1]="rb";
            board[8][8]="rb";

            board[1][2]="nw";
            board[1][7]="nw";
            board[8][2]="nb";
            board[8][7]="nb";

            board[1][3]="bw";
            board[1][6]="bw";
            board[8][3]="bb";
            board[8][6]="bb";

            board[1][5]="qw";
            board[1][4]="kw";
            board[8][5]="qb";
            board[8][4]="kb";
        }
    }
    void show()
    {
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

}
