package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameOverWindow extends GridPane {
    Label gameOver;
    GameOverWindow()
    {
        gameOver = new Label("Game Over");
        add(gameOver,3,2);
        gameOver.setTextFill(Color.web("#ff0000"));
        gameOver.setFont(Font.font("Arial", 50));
    }
}
