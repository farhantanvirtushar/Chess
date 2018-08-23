package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveListener implements EventHandler<ActionEvent> {
    Cell cell;
    Play play;
    MoveListener(int row,int col,Play play)
    {
        cell = new Cell(row,col);
        this.play = play;
    }
    @Override
    public void handle(ActionEvent event) {
        if(!(play.data.cpuMove) && !(play.data.gameOver))
        {
            play.data.move(cell);
            if((play.data.cpuMove)&&!(play.data.gameOver))
            {

                play.data.pcMakeMove();
            }
        }

    }
}
