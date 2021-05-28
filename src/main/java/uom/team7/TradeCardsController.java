package uom.team7;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class TradeCardsController {

    @FXML public Button closeButton;
    @FXML public Label troopLabel,cavalryLabel,artilleryLabel,totalLabel;
    @FXML public Spinner<Integer> troopSpinner,cavalrySpinner,artillerySpinner;


    @FXML
    public void BackButton() throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void TradeButton(Player player,int numOfTrades) throws IOException {
    }

    public void initialize(Player player) {
        //Spinner Initialize
        SpinnerValueFactory<Integer> troopValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,player.cards.getCards()[0],0);
        SpinnerValueFactory<Integer> cavalryValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,player.cards.getCards()[1],0);
        SpinnerValueFactory<Integer> artilleryValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,player.cards.getCards()[2],0);
        troopSpinner.setValueFactory(troopValue);
        cavalrySpinner.setValueFactory(cavalryValue);
        artillerySpinner.setValueFactory(artilleryValue);

        //Labels Initialize
        troopLabel.setText("x " + player.cards.getCards()[0]);
        cavalryLabel.setText("x " + player.cards.getCards()[1]);
        artilleryLabel.setText("x " + player.cards.getCards()[1]);
        totalLabel.setText("0");
    }
}
