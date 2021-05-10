package uom.team7;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TradeCardsController {
    @FXML
    public Button closeButton;


    @FXML
    public void BackButton() throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();


    }

    @FXML
    public void TradeButton(Player player,int numOfTrades) throws IOException {



    }
}
