package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.*;


public class Menu extends GridPane {

    Button white;
    Button black;
    Label playAs;
    Data data;
    Menu(Data data)
    {
        playAs = new Label("Play AS");
        white = new Button("",new ImageView(data.playAsWhite));
        black = new Button("",new ImageView(data.playAsBlack));
        playAs.setTextFill(Color.web("#ffffff"));
        playAs.setFont(Font.font("Arial", 50));
        this.data=data;
        setVgap(20);
        setHgap(100);
        add(playAs,5,5);
        add(white,5,8);
        add(black,5,11);
        BackgroundImage backgroundImage = new BackgroundImage(data.bgImage,BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));

        white.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.setPlayerWhite();
            }
        });
        black.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.setPlayerBlack();
            }
        });
    }

}
