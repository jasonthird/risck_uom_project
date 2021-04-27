package uom.team7;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class BoardController {
    private int numPlayers;

    @FXML
    Label playersText;

    public void changeText(String s) {
        playersText.setText(s);
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("StartMenu");
    }

}
