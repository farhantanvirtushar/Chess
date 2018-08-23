package sample;

public class Cell{

    int row;
    int column;
    Cell(int i,int j)
    {
        row=i;
        column=j;
        if((i<1)||(i>8)||(j<1)||(j>8))
        {
            System.out.println(" warning "+ i +" , "+j);
        }
    }
    void set(int i,int j)
    {
        row=i;
        column=j;
    }
    boolean equals(int i,int j)
    {
        if((row == i)&&(column == j))
        {
            return true;
        }
        return false;
    }
    boolean equals(Cell cell)
    {
        if((row == cell.row)&&(column == cell.column))
        {
            return true;
        }
        return false;
    }
}