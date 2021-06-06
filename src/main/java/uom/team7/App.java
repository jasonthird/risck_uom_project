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
    private static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        scene = new Scene(loadFXML("controllers/StartMenu.fxml"), 800, 600);
        primaryStage.setTitle("Risck");
        //icon set
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        return fxmlLoader.load();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    public static void main(String[] args) {
        launch(args);
    }

    public static void startGame(int numPlayers) throws IOException { new GameLogic(numPlayers, primaryStage); }


}