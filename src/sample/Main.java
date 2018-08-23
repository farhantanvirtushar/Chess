package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    Scene menuScene;
    Data data;
    @Override
    public void start(Stage window) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Chess");
        data = new Data(window);
        window.setWidth(data.maxWidth);
        window.setHeight(data.maxHeight);
        menuScene = new Scene(new Menu(data));
        window.setScene(menuScene);
        window.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
