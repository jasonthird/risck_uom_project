package uom.team7;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static java.util.Objects.*;


public class BoardController  {

    @FXML
    private Button closeButton, attackButton, skipButton, tradeButton;
    @FXML
    private Label playerLabel, unsedTroopsLabel, upkeepLabel, fortifyLabel;
    private Country country,country2;
    private boolean twoSelected = false,oneSelected = false;
    private GameLogic game;

    @FXML
    private void switchToStartMenu() {
        //close current stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        //create a new stage
        Parent root;
        try {
            root = FXMLLoader.load(requireNonNull(getClass().getResource("FXML/StartMenu.fxml")));
            stage.setScene(new Scene(root, 800, 600));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void attackButton() {
        //Sets the attackButton disable again
        attackButton.setStyle("-fx-background-color: #bd1111");
        attackButton.setDisable(true);
        //Reset selected flags
        oneSelected = false;
        twoSelected = false;
        System.out.println("Player:"+game.getCurrentPlayer().getId()+" Attack: "+country2.toString()+"/From: "+country.toString());
        //Initialize attack
        if(game.getWorld().attack(country,country2)) {
            Parent root;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Victory.fxml"));
                root = fxmlLoader.load();
                MessageController messageController = fxmlLoader.getController();
                messageController.init(game,country,country2);
                updateMap(game.getWorld().getPlayers(), game.getScene());
                Stage stage = new Stage();
                stage.setTitle("RISK");
                stage.setScene(new Scene(root, 300, 200));
                stage.setResizable(false);
                //stage.initStyle(StageStyle.UNDECORATED);
                stage.centerOnScreen();
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Check if the current player is the winner
        if(game.getWorld().checkWin(game.getWorld().getPlayers())){
            Parent root;
            try {
                root = FXMLLoader.load(requireNonNull(getClass().getResource("FXML/WinnerMessage.fxml")));
                Stage stage = new Stage();
                stage.setTitle("RISK");
                stage.setScene(new Scene(root, 450, 200));
                stage.setResizable(false);
                stage.alwaysOnTopProperty();
                //stage.initStyle(StageStyle.UNDECORATED);
                stage.centerOnScreen();
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        updateMap(game.getWorld().getPlayers(), game.getScene());
    }

    @FXML
    private void skipButton() {
        game.setState(game.getState() + 1);
        twoSelected = false;
        oneSelected = false;
        updateMap(game.getWorld().getPlayers(), game.getScene());
    }

    @FXML
    private void tradeCardsButton() {
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/TradeCards.fxml"));
            root = fxmlLoader.load();
            TradeCardsController tradeCardsController = fxmlLoader.getController();
            tradeCardsController.init(game);
            Stage stage = new Stage();
            stage.setTitle("RISK");
            stage.setScene(new Scene(root, 300, 370));
            stage.setResizable(false);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.centerOnScreen();
            tradeButton.setDisable(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadWhenClicked(ActionEvent event) {

        Button button = (Button) event.getSource();

        //Upkeep handler
        String buttonId;
        if (skipButton.isDisable()) {
            buttonId = button.getId();
            Country country = game.getWorld().fortify(buttonId,game.getCurrentPlayer());
            button.setText(String.valueOf(country.getNumTroops()));
            unsedTroopsLabel.setText("x" + game.getCurrentPlayer().getUnsedTroops());
        }

        //attack phase handler
        else if (tradeButton.isDisable()) {
            buttonId = button.getId();
            //If the first country is selected do stuff
            if ( !oneSelected && !twoSelected ){
                country = game.getWorld().findCountry(buttonId);
                if(game.getCurrentPlayer().countriesOwned.contains(country) && country.getNumTroops() > 1) {
                    Button b1 = (Button) button.lookup("#" + country.toString());
                    b1.setStyle("fx-border-color: #ffffff");
                    System.out.println("Selected Country:" + country.toString());
                    oneSelected = true;
                }
            }
            else {
                //If the second country is selected do stuff
                if( oneSelected && !twoSelected) {
                    country2 = game.getWorld().findCountry(buttonId);
                    if(!game.getCurrentPlayer().countriesOwned.contains(country2) && country.getAdjacentCountries().contains(country2)) {
                        Button b2 = (Button) button.lookup("#" + country2.toString());
                        b2.setStyle("fx-border-color: #ffffff");
                        System.out.println("Selected Country:" + country2.toString());
                        if (game.getWorld().attackCheck(country, country2, game.getCurrentPlayer())) {
                            attackButton.setStyle("-fx-background-color: #0fea88");
                            attackButton.setDisable(false);
                        }
                        twoSelected = true;
                    }
                    else {
                        updateMap(game.getWorld().getPlayers(), game.getScene());
                        twoSelected =false;
                    }
                    //Reset selected countries if the user select a third country
                }else{
                    updateMap(game.getWorld().getPlayers(), game.getScene());
                    attackButton.setStyle("-fx-background-color: #bd1111");
                    attackButton.setDisable(true);
                    twoSelected =false;
                }
                oneSelected = false;
            }
        }

        //Endturn handler
        else if (attackButton.isDisable()) {
            buttonId = button.getId();
            if (!oneSelected && !twoSelected) {
                country = game.getWorld().findCountry(buttonId);
                if(game.getCurrentPlayer().countriesOwned.contains(country) & country.getNumTroops() > 1) {
                    Button b1 = (Button) button.lookup("#" + country.toString());
                    b1.setStyle("fx-border-color: #ffffff");
                    System.out.println("Selected Country:" + country.toString());
                    oneSelected = true;
                }
            } else {
                if( oneSelected && !twoSelected) {
                    country2 = game.getWorld().findCountry(buttonId);
                    if (game.getCurrentPlayer().countriesOwned.contains(country2) && game.getWorld().findPath(country,country2) && country != country2) {
                        Button b2 = (Button) button.lookup("#" + country2.toString());
                        b2.setStyle("fx-border-color: #ffffff");
                        System.out.println("Selected Country:" + country2.toString());
                        if (game.getWorld().moveArmyCheck(country, country2, game.getCurrentPlayer())) {
                            Parent root;
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Fortify.fxml"));
                                root = fxmlLoader.load();
                                MessageController messageController = fxmlLoader.getController();
                                messageController.init(game,country, country2);
                                Stage stage = new Stage();
                                stage.setTitle("RISK");
                                stage.setScene(new Scene(root, 250, 170));
                                stage.setResizable(false);
                                //stage.initStyle(StageStyle.UNDECORATED);
                                stage.centerOnScreen();
                                stage.show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        twoSelected = true;
                    }else {
                        updateMap(game.getWorld().getPlayers(), game.getScene());
                        twoSelected =false;
                    }
                }else{
                    updateMap(game.getWorld().getPlayers(), game.getScene());
                    attackButton.setStyle("-fx-background-color: #bd1111");
                    attackButton.setDisable(true);
                    twoSelected =false;
                }
                oneSelected = false;
            }
        }
    }

    public void init(GameLogic gameLogic){
        game = gameLogic;
        playerLabel.setStyle("-fx-text-fill:" + game.getCurrentPlayer().getColor());
        playerLabel.setText("PLAYER " + game.getCurrentPlayer().getId());
        unsedTroopsLabel.setText("x" + game.getCurrentPlayer().getUnsedTroops());
    }

    public  void updateMap(Player[] players, Scene scene){
        for (Player p : players) {
            for (Country c : p.countriesOwned) {
                Button b = (Button) scene.lookup("#" + c.toString());
                b.setText(String.valueOf((c.getNumTroops())));
                b.setStyle("-fx-background-color:" + p.getColor());
            }
        }
    }

    public void placeTroops() {
        upkeepLabel.setStyle("-fx-text-fill: #777d78");
        attackButton.setDisable(true);
        skipButton.setDisable(true);
        tradeButton.setDisable(true);
    }

    public void upkeep() {
        //Turn on the UPKEEP indicator
        upkeepLabel.setStyle("-fx-text-fill: #0fea88");
        //Turn off the FORTIFY indicator
        fortifyLabel.setStyle("-fx-text-fill: #777d78");
        attackButton.setDisable(true);
        skipButton.setDisable(true);
        tradeButton.setDisable(true);
    }

    public void attackPhase() {
        //Turn off the UPKEEP indicator
        upkeepLabel.setStyle("-fx-text-fill: #777d78");
        //Turn off the FORTIFY indicator
        fortifyLabel.setStyle("-fx-text-fill: #777d78");
        skipButton.setDisable(false);
        tradeButton.setDisable(true);
    }

    public void endTurn() {
        //Turn off the UPKEEP indicator
        upkeepLabel.setStyle("-fx-text-fill: #777d78");
        //Turn on the FORTIFY indicator
        fortifyLabel.setStyle("-fx-text-fill: #0fea88");
        skipButton.setDisable(false);
        tradeButton.setDisable(false);
        attackButton.setDisable(true);
        //Check if the player won a battle in attack phase,if true add a random card
    }

    public void fullHand(GameLogic game){
        //If fullHandCheck = true display TradeCards window
        if (game.isFlag()) {
            Parent root;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/TradeCards.fxml"));
                //root = FXMLLoader.load(getClass().getResource("FXML/TradeCards.fxml"));
                root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("RISK");
                stage.setScene(new Scene(root, 300, 370));
                stage.setResizable(false);
                //stage.initStyle(StageStyle.UNDECORATED);
                stage.centerOnScreen();
                stage.alwaysOnTopProperty();
                stage.show();
                TradeCardsController tradeCardsController = fxmlLoader.getController();
                tradeCardsController.init(game);
                tradeCardsController.getCloseButton().setDisable(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        game.setFlag(false);
    }


    public void setTwoSelected(boolean twoSelected) { this.twoSelected = twoSelected; }

    public void setOneSelected(boolean oneSelected) { this.oneSelected = oneSelected; }

    public Button getTradeButton() { return tradeButton; }

}


