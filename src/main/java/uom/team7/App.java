package uom.team7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uom.team7.model.GameLogic;

import java.io.IOException;

public class App extends Application {

    private static Stage primaryStage;
    private static Scene startMenu;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        startMenu = new Scene(loadFXML(), 800, 600);
        primaryStage.setTitle("Risck");
        //icon set
        primaryStage.setScene(startMenu);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("controllers/StartMenu.fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void startGame(int numPlayers) { new GameLogic(numPlayers, primaryStage); }

    public static Scene getScene() {
        return startMenu;
    }
}