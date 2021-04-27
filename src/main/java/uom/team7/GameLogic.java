package uom.team7;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class GameLogic {

    private int numPlayers;

    public GameLogic(int n,Scene scene) throws IOException {
        numPlayers=n;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("BoardGui.fxml"));
        scene.setRoot(fxmlLoader.load());
        BoardController boardController = fxmlLoader.getController();
        boardController.changeText("game with "+numPlayers+" players");

    }

}
