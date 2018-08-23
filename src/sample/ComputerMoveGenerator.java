package sample;

public class ComputerMoveGenerator{
    Data data ;
    ComputerMoveGenerator(Data data)
    {
        this.data=data;
    }
    String [][] findBestMove(String board[][],CastlingChecker cstChecker,int h)
    {
        String boardCpy[][] = new String[9][9];
        String bestMove[][] = new String[9][9];
        int max = -1000000;
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                if(board[i][j].charAt(1)==data.cpuColor)
                {
                    CastlingChecker cstCpy = cstChecker.copy();
                    Cell moves[]=data.countLegalMoves.legalMoves(i,j,board,cstCpy);
                    Cell move1 = new Cell(i,j);
                    for(int k=0;k<30;k++)
                    {
                        if(moves[k]==null)
                        {
                            break;
                        }
                        boardCpy = copyArr(board);
                        makeMove(boardCpy,cstChecker,move1,moves[k]);
                        int r=moves[k].row;
                        int c=moves[k].column;
                        if(board[r][c].charAt(0)=='k')
                        {
                            return boardCpy;
                        }
                        int a = findBestMove2(boardCpy,cstChecker,-1000000,1000000,h+1);
                        if(max <= a)
                        {
                            max = a;
                            bestMove = copyArr(boardCpy);
                        }
                    }
                }
            }
        }
        return bestMove;
    }
    int findBestMove2(String board[][],CastlingChecker cstChecker,int alpha,int beta,int h)
    {
        int min,max;
        min = 1000000;
        max = -1000000;
        int ans;
        String boardCpy[][] = new String[9][9];
        if(h == data.GAME_TREE_HEIGHT)
        {
            ans = evaluate(board);
            return ans;
        }
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                char ch;
                if((h%2)==0)
                {
                    ch = data.cpuColor;
                }
                else
                {
                    ch = data.playerColor;
                }
                if(board[i][j].charAt(1)==ch)
                {
                    CastlingChecker cstCpy = cstChecker.copy();
                    Cell moves[]=data.countLegalMoves.legalMoves(i,j,board,cstCpy);
                    Cell move1 = new Cell(i,j);
                    for(int k=0;k<30;k++)
                    {
                        if(beta<=alpha)
                        {
                            if((h%2)==0)
                            {
                                ans = max;
                            }
                            else
                            {
                                ans = min;
                            }
                            return ans;
                        }
                        if(moves[k]==null)
                        {
                            break;
                        }
                        int r=moves[k].row;
                        int c=moves[k].column;
                        if((i<1)||(i>8)||(j<1)||(j>8))
                        {
                            System.out.println(" warning "+ i +" , "+j);
                        }
                        if(board[r][c].charAt(0)=='k')
                        {
                            if(ch == data.playerColor)
                            {
                                return (-1000000);
                            }
                            else
                            {
                                return (1000000);
                            }
                        }
                        boardCpy = copyArr(board);
                        makeMove(boardCpy,cstChecker,move1,moves[k]);
                        int a = findBestMove2(boardCpy,cstChecker,alpha,beta,h+1);
                        if((h%2)==0)
                        {
                            if(max<a)
                            {
                                max = a;
                            }
                            if(alpha<a)
                            {
                                alpha=a;
                            }
                        }
                        else
                        {
                            if(min > a)
                            {
                                min = a;
                            }
                            if(beta>a)
                            {
                                beta = a;
                            }
                        }
                    }
                }
            }
        }
        if((h%2)==0)
        {
            ans = max;
        }
        else
        {
            ans = min;
        }
        return ans;
    }
    int evaluate(String board[][])
    {
        int ans=0;
        for(int i=1;i<=8;i++)
        {
            for (int j=1;j<=8;j++)
            {
                int a=0;
                if(board[i][j].equals("##"))
                {
                    a=0;
                }
                else if(board[i][j].equals("pw"))
                {
                    a=-10;
                }
                else if(board[i][j].equals("pb"))
                {
                    a=10;
                }
                else if(board[i][j].equals("nw"))
                {
                    a=-30;
                }
                else if(board[i][j].equals("nb"))
                {
                    a=30;
                }
                else if(board[i][j].equals("bw"))
                {
                    a=-30;
                }
                else if(board[i][j].equals("bb"))
                {
                    a=30;
                }
                else if(board[i][j].equals("rw"))
                {
                    a=-50;
                }
                else if(board[i][j].equals("rb"))
                {
                    a=50;
                }
                else if(board[i][j].equals("qw"))
                {
                    a=-90;
                }
                else if(board[i][j].equals("qb"))
                {
                    a=90;
                }
                else if(board[i][j].equals("kw"))
                {
                    a=-100000;
                }
                else if(board[i][j].equals("kb"))
                {
                    a=100000;
                }
                ans+=a;
            }
        }
        if(data.cpuColor == 'w')
        {
            ans=ans*(-1);
        }
        return ans;
    }
    void show(String str[][])
    {
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                System.out.print(str[i][j]+ " ");
            }
            System.out.println();
        }
    }
    String [][] copyArr(String str[][])
    {
        String boardCpy[][] = new String[9][9];
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                boardCpy[i][j]=str[i][j];
            }
        }
        return boardCpy;
    }
    void makeMove(String board[][],CastlingChecker cstChecker,Cell move1,Cell move2)
    {

        String temp = board[move1.row][move1.column];
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
                    t=board[move1.row][6];
                    board[move1.row][6] = board[move1.row][8];
                    board[move1.row][8]=t;
                }
                else if (move2.column == 3)
                {
                    String t;
                    t=board[move1.row][4];
                    board[move1.row][4] = board[move1.row][1];
                    board[move1.row][1]=t;
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
        board[move2.row][move2.column] = temp;
        board[move1.row][move1.column] = "##";
        if(((move2.row == 1)||(move2.row == 8))&&(board[move2.row][move2.column].charAt(0) =='p'))
        {
            if(board[move2.row][move2.column].charAt(1) =='w')
            {
                board[move2.row][move2.column] = "qw";
            }
            else if(board[move2.row][move2.column].charAt(1) =='b')
            {
                board[move2.row][move2.column] = "qb";
            }
        }
    }
}
