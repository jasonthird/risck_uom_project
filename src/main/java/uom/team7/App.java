package uom.team7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

import javax.print.attribute.standard.Media;
import java.io.File;
import java.io.IOException;

public class App extends Application {

    private static Stage primaryStage;
    private static Scene StartMenu;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        StartMenu = new Scene(loadFXML(), 800, 600);

        primaryStage.getIcons().add(new Image(("file:uom/team7/images/skip.png")));
        primaryStage.setTitle("Risck");

        primaryStage.setScene(StartMenu);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    static void setRoot(Scene scene) throws IOException {
        scene.setRoot(loadFXML());
    }

    private static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("FXML/StartMenu.fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void startGame(int numPlayers) throws IOException {
        new GameLogic(numPlayers, primaryStage);
    }


}