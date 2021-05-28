package uom.team7;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class StartMenuController {

    @FXML
    private ToggleGroup NumPlayers;


    @FXML
    private void startGameButton() throws IOException {

        ToggleButton selectedButton = (ToggleButton) NumPlayers.getSelectedToggle();
        App.startGame(Integer.parseInt(selectedButton.getText()));


    }

    @FXML
    private void ExitButton() throws IOException{
        Platform.exit();
    }

    @FXML
    private void HowToPLayButton() throws IOException{
        String url_open ="https://www.hasbro.com/common/instruct/risk.pdf";
        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
    }

}
