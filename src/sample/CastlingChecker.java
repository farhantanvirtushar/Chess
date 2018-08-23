package sample;

public class CastlingChecker{
    public boolean kwNotMoved,kbNotMoved,rw1NotMoved,rw2NotMoved,rb1NotMoved,rb2NotMoved;

    CastlingChecker()
    {
        kbNotMoved=true;
        kwNotMoved=true;
        rb1NotMoved=true;
        rb2NotMoved=true;
        rw1NotMoved=true;
        rw2NotMoved = true;
    }
    CastlingChecker copy()
    {
        CastlingChecker temp = new CastlingChecker();
        temp.kbNotMoved=this.kbNotMoved;
        temp.kwNotMoved=this.kwNotMoved;
        temp.rb1NotMoved=this.rb1NotMoved;
        temp.rb2NotMoved=this.rb2NotMoved;
        temp.rw1NotMoved=this.rw1NotMoved;
        temp.rw2NotMoved=this.rw2NotMoved;
        return  temp;
    }
}
