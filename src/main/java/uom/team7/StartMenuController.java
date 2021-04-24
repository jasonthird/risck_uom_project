package uom.team7;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;


public class StartMenuController {

    @FXML
    private ToggleGroup NumPlayers;

    @FXML
    private void startGameButton() throws IOException {
        ToggleButton selectedButton = (ToggleButton) NumPlayers.getSelectedToggle();
        System.out.println(selectedButton.getText());
        GameLogic game = new GameLogic(Integer.parseInt(selectedButton.getText()));
        //game.startGame();
    }

}
