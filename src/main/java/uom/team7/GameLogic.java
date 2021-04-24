package uom.team7;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class GameLogic {

    private int numPlayers;

    public GameLogic(int n) throws IOException {
        numPlayers=n;
        App.setRoot("BoardGui");

    }

}
