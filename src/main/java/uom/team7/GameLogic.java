package uom.team7;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class GameLogic {
    private int numPlayers;

    public GameLogic(int n) {
        numPlayers=n;
    }
    public void startGame() throws IOException {
        App.setRoot("BoardGui");
        changeText(Integer.toString(numPlayers));
    }
    @FXML
    Label playersText;

    private void changeText(String n) {
        playersText.setText("Game with "+n+" players");
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("StartMenu");
    }

}
