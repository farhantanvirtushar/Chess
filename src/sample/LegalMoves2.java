package sample;

public class LegalMoves2{
    Data data;
    LegalMoves2(Data data)
    {
        this.data=data;
    }

    public Cell[] legalMoves(int row,int col ,String board[][])
    {
        Cell legal[] = new Cell[100];
        String str=board[row][col];
        char ch = str.charAt(0);
        char color = str.charAt(1);
        int ind = 0;

        //if(kingFree)
        {
            if(ch == 'p')
            {
                char playerColor;
                if(data.player == data.WHITE)
                {
                    playerColor = 'w';
                }
                else
                {
                    playerColor = 'b';
                }
                if((color == playerColor)&&(row - 1 >= 1))
                {
                    if(board[row - 1][col].equals("##"))
                    {
                        legal[ind] = new Cell(row - 1, col);
                        ind++;
                    }
                    if(col +1<=8)
                    {
                        if(!(board[row - 1][col+1].equals("##"))&&(board[row - 1][col+1].charAt(1)!=color))
                        {
                            legal[ind]=new Cell(row-1,col+1);
                            ind++;
                        }
                    }
                    if(col -1>=1)
                    {
                        if(!(board[row - 1][col-1].equals("##"))&&(board[row - 1][col-1].charAt(1)!=color))
                        {
                            legal[ind]=new Cell(row-1,col-1);
                            ind++;
                        }
                    }
                    if(row == 7)
                    {
                        if(board[row - 2][col].equals("##"))
                        {
                            legal[ind] = new Cell(row - 2, col);
                            ind++;
                        }
                    }
                }
                else if((color != playerColor)&&(row + 1 <= 8))
                {
                    if(board[row + 1][col].equals("##"))
                    {
                        legal[ind] = new Cell(row + 1, col);
                        ind++;
                    }
                    if(col +1<=8)
                    {
                        if(!(board[row + 1][col+1].equals("##"))&&(board[row + 1][col+1].charAt(1)!=color))
                        {
                            legal[ind]=new Cell(row+1,col+1);
                            ind++;
                        }
                    }
                    if(col -1>=1)
                    {
                        if(!(board[row + 1][col-1].equals("##"))&&(board[row + 1][col-1].charAt(1)!=color))
                        {
                            legal[ind]=new Cell(row+1,col-1);
                            ind++;
                        }
                    }
                    if(row == 2)
                    {
                        if(board[row + 2][col].equals("##"))
                        {
                            legal[ind] = new Cell(row + 2, col);
                            ind++;
                        }
                    }
                }
            }
            else if(ch == 'r')
            {
                for(int i=row+1;i<=8;i++)
                {
                    if(board[i][col].equals("##"))
                    {
                        legal[ind]=new Cell(i,col);
                        ind++;
                    }
                    else if(board[i][col].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(i,col);
                        ind++;
                        break;
                    }
                    else if(board[i][col].charAt(1)==color)
                    {
                        break;
                    }
                }
                for(int i=row-1;i>=1;i--)
                {
                    if(board[i][col].equals("##"))
                    {
                        legal[ind]=new Cell(i,col);
                        ind++;
                    }
                    else if(board[i][col].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(i,col);
                        ind++;
                        break;
                    }
                    else if(board[i][col].charAt(1)==color)
                    {
                        break;
                    }
                }
                for(int j=col+1;j<=8;j++)
                {
                    if(board[row][j].equals("##"))
                    {
                        legal[ind]=new Cell(row,j);
                        ind++;
                    }
                    else if(board[row][j].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(row,j);
                        ind++;
                        break;
                    }
                    else if(board[row][j].charAt(1)==color)
                    {
                        break;
                    }
                }
                for(int j=col-1;j>=1;j--)
                {
                    if(board[row][j].equals("##"))
                    {
                        legal[ind]=new Cell(row,j);
                        ind++;
                    }
                    else if(board[row][j].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(row,j);
                        ind++;
                        break;
                    }
                    else if(board[row][j].charAt(1)==color)
                    {
                        break;
                    }
                }
            }
            else if(ch == 'n')
            {
                int x[] = {2,2,-2,-2,1,1,-1,-1};
                int y[] = {1,-1,1,-1,2,-2,2,-2};
                for(int i=0;i<8;i++)
                {
                    int a=row+y[i];
                    int b=col+x[i];
                    if((a>=1)&&(a<=8)&&(b>=1)&&(b<=8))
                    {
                        if(board[a][b].equals("##"))
                        {
                            legal[ind]=new Cell(a,b);
                            ind++;
                        }
                        else if(board[a][b].charAt(1)!=color)
                        {
                            legal[ind]=new Cell(a,b);
                            ind++;
                        }
                    }
                }
            }
            else if(ch == 'b')
            {
                int i,j;
                i=row+1;
                j=col+1;
                for(;(i<=8)&&(j<=8);i++,j++)
                {

                    if(board[i][j].equals("##"))
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                    }
                    else if(board[i][j].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                        break;
                    }
                    else if(board[i][j].charAt(1)==color)
                    {
                        break;
                    }
                }
                i=row+1;
                j=col-1;
                for(;(i<=8)&&(j>=1);i++,j--)
                {

                    if(board[i][j].equals("##"))
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                    }
                    else if(board[i][j].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                        break;
                    }
                    else if(board[i][j].charAt(1)==color)
                    {
                        break;
                    }
                }
                i=row - 1;
                j=col + 1;

                for(;(i>=1)&&(j<=8);i--,j++)
                {

                    if(board[i][j].equals("##"))
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                    }
                    else if(board[i][j].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                        break;
                    }
                    else if(board[i][j].charAt(1)==color)
                    {
                        break;
                    }

                }
                i=row-1;
                j=col-1;
                for(;(i>=1)&&(j>=1);i--,j--)
                {
                    if(board[i][j].equals("##"))
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                    }
                    else if(board[i][j].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                        break;
                    }
                    else if(board[i][j].charAt(1)==color)
                    {
                        break;
                    }

                }
            }
            else if(ch == 'q')
            {
                for(int i=row+1;i<=8;i++)
                {
                    if(board[i][col].equals("##"))
                    {
                        legal[ind]=new Cell(i,col);
                        ind++;
                    }
                    else if(board[i][col].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(i,col);
                        ind++;
                        break;
                    }
                    else if(board[i][col].charAt(1)==color)
                    {
                        break;
                    }
                }
                for(int i=row-1;i>=1;i--)
                {
                    if(board[i][col].equals("##"))
                    {
                        legal[ind]=new Cell(i,col);
                        ind++;
                    }
                    else if(board[i][col].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(i,col);
                        ind++;
                        break;
                    }
                    else if(board[i][col].charAt(1)==color)
                    {
                        break;
                    }
                }
                for(int j=col+1;j<=8;j++)
                {
                    if(board[row][j].equals("##"))
                    {
                        legal[ind]=new Cell(row,j);
                        ind++;
                    }
                    else if(board[row][j].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(row,j);
                        ind++;
                        break;
                    }
                    else if(board[row][j].charAt(1)==color)
                    {
                        break;
                    }
                }
                for(int j=col-1;j>=1;j--)
                {
                    if(board[row][j].equals("##"))
                    {
                        legal[ind]=new Cell(row,j);
                        ind++;
                    }
                    else if(board[row][j].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(row,j);
                        ind++;
                        break;
                    }
                    else if(board[row][j].charAt(1)==color)
                    {
                        break;
                    }
                }
                int i,j;
                i=row+1;
                j=col+1;
                for(;(i<=8)&&(j<=8);i++,j++)
                {

                    if(board[i][j].equals("##"))
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                    }
                    else if(board[i][j].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                        break;
                    }
                    else if(board[i][j].charAt(1)==color)
                    {
                        break;
                    }
                }
                i=row+1;
                j=col-1;
                for(;(i<=8)&&(j>=1);i++,j--)
                {

                    if(board[i][j].equals("##"))
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                    }
                    else if(board[i][j].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                        break;
                    }
                    else if(board[i][j].charAt(1)==color)
                    {
                        break;
                    }
                }
                i=row - 1;
                j=col + 1;

                for(;(i>=1)&&(j<=8);i--,j++)
                {

                    if(board[i][j].equals("##"))
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                    }
                    else if(board[i][j].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                        break;
                    }
                    else if(board[i][j].charAt(1)==color)
                    {
                        break;
                    }

                }
                i=row-1;
                j=col-1;
                for(;(i>=1)&&(j>=1);i--,j--)
                {
                    if(board[i][j].equals("##"))
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                    }
                    else if(board[i][j].charAt(1)!=color)
                    {
                        legal[ind]=new Cell(i,j);
                        ind++;
                        break;
                    }
                    else if(board[i][j].charAt(1)==color)
                    {
                        break;
                    }

                }
            }
        }
        if(ch == 'k')
        {
            int x[] = {-1,-1,-1,0,0,1,1,1};
            int y[] = {-1,0,1,-1,1,-1,0,1};
            for(int i=0;i<8;i++)
            {
                int a=row+y[i];
                int b=col+x[i];
                if((a>=1)&&(a<=8)&&(b>=1)&&(b<=8))
                {
                    //if(data.legalMoves2.isFree(color,a,b))
                    {
                        if(board[a][b].equals("##"))
                        {
                            legal[ind]=new Cell(a,b);
                            ind++;
                        }
                        else if(board[a][b].charAt(1)!=color)
                        {
                            legal[ind]=new Cell(a,b);
                            ind++;
                        }
                    }
                }
            }

        }

        return legal;
    }
    boolean isFree(char pl,int row,int col,String board[][])
    {
        char op;
        if(pl == 'w')
        {
            op='b';
        }
        else
        {
            op='w';
        }
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                if((board[i][j].charAt(1)==op))
                {
                    Cell moves[] = legalMoves(i,j,board);
                    for(int k=0;k<30;k++)
                    {
                        if(moves[k]!=null)
                        {
                            if(moves[k].equals(row,col))
                            {
                                return false;
                            }
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }
        }
        return true;
    }

    boolean isKingFree(char pl,String board[][])
    {

        boolean b = true;
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                if((board[i][j].charAt(0)=='k')&&(board[i][j].charAt(1)==pl))
                {
                    b=isFree(pl,i,j,board);
                }
            }
        }
        return b;
    }
}
