package uom.team7;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class TradeCardsController {
    private int numOfTrades;
    private Player player;
    @FXML
    public Button closeButton;
    @FXML
    public Label troopLabel, cavalryLabel, artilleryLabel, totalLabel;
    @FXML
    public Spinner<Integer> troopSpinner, cavalrySpinner, artillerySpinner;
    private BoardController board;
    private World world;


    @FXML
    public void BackButton() throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        board.tradeButton.setDisable(false);
    }

    @FXML
    public void TradeButton() throws IOException {
        numOfTrades = player.cards.redeemCards(troopSpinner.getValue(), cavalrySpinner.getValue(), artillerySpinner.getValue(), world);

        if(numOfTrades != 0) {
            System.out.println("Trades:" + numOfTrades);
            player.setUnsedTroops(numOfTrades);
        }
        init(player,board,world);
    }

    //Initialize the values of scene's components
    public void init(Player player,BoardController boardController,World world) {
        this.board = boardController;
        this.world = world;
        this.player = player;
        //Spinner Initialize
        if(!player.cards.fullHandCheck()){
            closeButton.setDisable(false);
        }
        SpinnerValueFactory<Integer> troopValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, player.cards.getCards()[0], 0);
        SpinnerValueFactory<Integer> cavalryValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, player.cards.getCards()[1], 0);
        SpinnerValueFactory<Integer> artilleryValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, player.cards.getCards()[2], 0);
        troopSpinner.setValueFactory(troopValue);
        cavalrySpinner.setValueFactory(cavalryValue);
        artillerySpinner.setValueFactory(artilleryValue);
        totalLabel.setText("");

        //Listeners for spinners to update totalLabel
        troopValue.valueProperty().addListener(e -> updateTotal(troopValue.getValue(), cavalryValue.getValue(), artilleryValue.getValue()));
        cavalryValue.valueProperty().addListener(e -> updateTotal(troopValue.getValue(), cavalryValue.getValue(), artilleryValue.getValue()));
        artilleryValue.valueProperty().addListener(e -> updateTotal(troopValue.getValue(), cavalryValue.getValue(), artilleryValue.getValue()));

        //Labels Initialize
        troopLabel.setText("x " + player.cards.getCards()[0]);
        cavalryLabel.setText("x " + player.cards.getCards()[1]);
        artilleryLabel.setText("x " + player.cards.getCards()[2]);

    }

    //Calculations for total
    public void updateTotal(int t, int c, int a) {
        int total = 0,n = world.numOfTrades; // temp variables to calculate the total IRT
        int[] value = new int[3];
        boolean flag = false;
        value[0] = t;
        value[1] = c;
        value[2] = a;

        //Calculate the total if all values are equal
        if ( (value[0] == value[1]) && (value[1] == value[2]) && value[0] > 0 ) {
            for(int i=0; i < value[0]; i++) {
                total += n ;
                n += 2;
            }
            totalLabel.setText(String.valueOf(total));
            //Flag indicator if the 1rst condition success don't go any further
            flag = true;
        }
        //Second condition : check for any value that is multiply of 3
        if(!flag) {
            int temp = world.numOfTrades;
            for (int i = 0; i < 3; i++) {
                if ( (value[i] != 0) && (value[i] % 3) == 0 && (value[i] >= 3) ) {
                    total += (n * (value[i] / 3) );
                    n += (2 * (value[i] / 3)) ;
                }

                if ( total >= world.numOfTrades ) {
                    totalLabel.setText(String.valueOf(total));
                } else { totalLabel.setText(""); }
            }
        }
    }
}
