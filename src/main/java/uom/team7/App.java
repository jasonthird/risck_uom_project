package uom.team7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;

import javax.print.attribute.standard.Media;
import java.io.File;
import java.io.IOException;

public class App extends Application {

    private static Scene StartMenu;
    @Override
    public void start(Stage stage) throws IOException {

        StartMenu = new Scene(loadFXML(), 800, 600);
        stage.setTitle("Risck");
        stage.setScene(StartMenu);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot() throws IOException {
        StartMenu.setRoot(loadFXML());
    }

    private static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("FXML/StartMenu.fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void startGame(int numPlayers) throws IOException {
        new GameLogic(numPlayers, StartMenu);
    }


}