package uom.team7;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class GameLogic {
    public World world;
    private Player[] players;


    public GameLogic(int numPlayers, Stage stage) throws IOException {

        //Game Data initialization
        world = new World(numPlayers);
        players = world.getPlayers();

        //Create a new stage
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Board.fxml"));
            root = fxmlLoader.load();
            Scene scene = new Scene(root, 1200, 900);

            BoardController boardController = fxmlLoader.getController();
            boardController.initCountriesWithButtons(players, scene);
            stage.setScene(scene);

            stage.centerOnScreen();
            stage.show();
            boardController.init(players[0],world);

           // placeTroops(players[0], boardController);

            //upkeep(players[0], boardController);
            attackPhase(players[0], boardController);
            //endTurn(players[0],boardController);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void placeTroops(Player player, BoardController boardController) {
        boardController.playerLabel.setStyle("-fx-text-fill:" + player.getColor());
        boardController.playerLabel.setText("PLAYER " + player.id);
        boardController.unsedTroopsLabel.setText("x" + player.getUnsedTroops());
        boardController.attackButton.setDisable(true);
        boardController.skipButton.setDisable(true);
        boardController.tradeButton.setDisable(true);

    }

    public void upkeep(Player player, BoardController boardController) {
        boardController.playerLabel.setStyle("-fx-text-fill:" + player.getColor());
        boardController.playerLabel.setText("PLAYER " + player.id);
        //Turn on the UPKEEP indicator
        boardController.upkeepLabel.setStyle("-fx-text-fill: #0fea88");
        //Turn off the FORTIFY indicator
        boardController.fortifyLabel.setStyle("-fx-text-fill: #777d78");
        boardController.attackButton.setDisable(true);
        boardController.skipButton.setDisable(true);
        boardController.tradeButton.setDisable(true);
        player.setWonCard(false);
        //Update and display unsedTroops
        world.updateUnsedTroops(player);
        boardController.unsedTroopsLabel.setText("x" + player.getUnsedTroops());
        //If fullHandCheck = true display TradeCards window
        //player.cards.addCards(0,5);
        if (player.cards.fullHandCheck()) {

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
                stage.show();
                TradeCardsController tradeCardsController =  fxmlLoader.getController();
                tradeCardsController.initialize(player);
                tradeCardsController.closeButton.setDisable(true);

                //Only if the player has cards < 5 can click on skip button
                if(!player.cards.fullHandCheck()) {
                   tradeCardsController.closeButton.setDisable(false);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //System waits for user interaction




    }

    public void attackPhase(Player player,BoardController boardController) {
        boardController.playerLabel.setStyle("-fx-text-fill:" + player.getColor());
        boardController.playerLabel.setText("PLAYER " + player.id);
        //Turn off the UPKEEP indicator
        boardController.upkeepLabel.setStyle("-fx-text-fill: #777d78");
        //Turn off the FORTIFY indicator
        boardController.fortifyLabel.setStyle("-fx-text-fill: #777d78");
        boardController.attackButton.setDisable(false);
        boardController.tradeButton.setDisable(true);
        boardController.unsedTroopsLabel.setText("x" + player.getUnsedTroops());

        //System waits for user interaction

    }

    public void endTurn(Player player,BoardController boardController) {
        boardController.playerLabel.setStyle("-fx-text-fill:" + player.getColor());
        boardController.playerLabel.setText("PLAYER " + player.id);
        //Turn off the UPKEEP indicator
        boardController.upkeepLabel.setStyle("-fx-text-fill: #777d78");
        //Turn on the FORTIFY indicator
        boardController.fortifyLabel.setStyle("-fx-text-fill: #0fea88");
        boardController.skipButton.setDisable(false);
        boardController.tradeButton.setDisable(false);
        boardController.attackButton.setDisable(true);
        boardController.unsedTroopsLabel.setText("x" + player.getUnsedTroops());

        //Check if the player won a battle in attack phase,if true add a random card
        player.cards.winCard(player.wonCard);

        //System waits for user interaction

    }
}
