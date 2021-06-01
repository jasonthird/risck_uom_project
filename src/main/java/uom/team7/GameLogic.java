package uom.team7;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class GameLogic {

    public  int state = 0, i = 0;
    public World world;
    private final Player[] players;
    BoardController boardController;
    public Scene scene;
    private Player currentPlayer;
    public boolean flag;



    public GameLogic(int numPlayers, Stage stage) throws IOException {

        //Game Data initialization
        world = new World(numPlayers);
        players = world.getPlayers();


        //Create a new stage
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Board.fxml"));
            root = fxmlLoader.load();
            scene = new Scene(root, 1200, 900);

            boardController = fxmlLoader.getController();
            boardController.updateMap(players, scene);
            stage.setScene(scene);
            stage.alwaysOnTopProperty();
            stage.centerOnScreen();
            stage.show();
           new Thread() {
                /* This Thread calculate's the current state of the current player.
                    The input state change whenever the world updates on Users action.
                    The loop ends when the win condition is achieved.In every 100 ms the Platform updates the
                    Board. */
                public void run() {
                    while (true) {
                        try {
                            currentPlayer = players[i];
                            if( currentPlayer.statusCheck()){

                                System.out.println("Player " + currentPlayer.id + "is dead");
                                if(currentPlayer == players[numPlayers - 1]){
                                    i = 0;
                                    System.out.println("i=0");
                                }else {
                                    i++;

                                    System.out.println("i++");
                                }
                                currentPlayer = players[i];
                                System.out.println("Current Player " + currentPlayer.id );
                                state = 1;
                            }
                            if (state == 0) {
                                if (currentPlayer == players[numPlayers - 1] && currentPlayer.getUnsedTroops() == 0) {
                                    i = 0;
                                    state = 1;
                                    currentPlayer = players[i];
                                    System.out.println("i=0");
                                } else if (currentPlayer.getUnsedTroops() == 0 && currentPlayer != players[numPlayers - 1]) {
                                    i++;
                                    System.out.println("i++");
                                }
                            }
                            if (state == 1) {
                                currentPlayer.setWonCard(false);
                                world.updateUnsedTroops(currentPlayer);
                                if(currentPlayer.cards.fullHandCheck()){
                                    System.out.println("Full Hand");
                                    state = 6;
                                    flag = true;
                                }else {
                                    state = 2;
                                }
                            }
                            if (state == 2) {
                                if (currentPlayer.getUnsedTroops() == 0) {
                                    state = 3;
                                }
                            }
                            if (state == 5) {
                                currentPlayer.cards.winCard(currentPlayer.isWonCard());
                                state = 1;
                                if (currentPlayer == players[numPlayers - 1]) {
                                    i = 0;
                                } else {
                                    i++;
                                }
                            }
                            if(state == 6  && !flag){
                                state = 2;
                            }
                            // imitating work
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        // update Board Map on FX thread
                        Platform.runLater(() -> {

                            if (state == 0) {
                                placeTroops(currentPlayer, boardController);
                            }
                            if( state == 6 && flag){
                                fullHand(currentPlayer,boardController, true);
                            }
                            if (state == 1 || state == 2) {
                                upkeep(currentPlayer, boardController);
                            }
                            if (state == 3) {
                                attackPhase(currentPlayer, boardController);
                            }
                            if (state == 4) {
                                endTurn(currentPlayer, boardController);
                            }
                            boardController.init(GameLogic.this, i, scene);
                        });
                    }
                }
            }.start();
            stage.centerOnScreen();
            stage.show();
            //boardController.init(GameLogic.this, i, scene);
          // attackPhase(players[0],boardController);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public Country fortify(String buttonText,Player player,World world){
        Country country = world.findCountry(buttonText);
        if (player.countriesOwned.contains(country) && player.getUnsedTroops() != 0) {
            world.fortify(country,1);
            System.out.println("Country: " + country + ", Troops: " + country.getNumTroops());
        }
        return  country;
    }



    public void placeTroops(Player player, BoardController boardController) {
        boardController.upkeepLabel.setStyle("-fx-text-fill: #777d78");
        boardController.attackButton.setDisable(true);
        boardController.skipButton.setDisable(true);
        boardController.tradeButton.setDisable(true);
    }

    public void fullHand(Player player, BoardController boardController,boolean flag){
        //If fullHandCheck = true display TradeCards window
        if (flag) {
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
                tradeCardsController.init(player,boardController,world);
                tradeCardsController.closeButton.setDisable(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.flag = false;
    }
    public void upkeep(Player player, BoardController boardController) {
        //Turn on the UPKEEP indicator
        boardController.upkeepLabel.setStyle("-fx-text-fill: #0fea88");
        //Turn off the FORTIFY indicator
        boardController.fortifyLabel.setStyle("-fx-text-fill: #777d78");
        boardController.attackButton.setDisable(true);
        boardController.skipButton.setDisable(true);
        boardController.tradeButton.setDisable(true);
    }

    public void attackPhase(Player player,BoardController boardController) {
        //Turn off the UPKEEP indicator
        boardController.upkeepLabel.setStyle("-fx-text-fill: #777d78");
        //Turn off the FORTIFY indicator
        boardController.fortifyLabel.setStyle("-fx-text-fill: #777d78");
        boardController.skipButton.setDisable(false);
        boardController.tradeButton.setDisable(true);
    }

    public void endTurn(Player player,BoardController boardController) {
        //Turn off the UPKEEP indicator
        boardController.upkeepLabel.setStyle("-fx-text-fill: #777d78");
        //Turn on the FORTIFY indicator
        boardController.fortifyLabel.setStyle("-fx-text-fill: #0fea88");
        boardController.skipButton.setDisable(false);
        boardController.tradeButton.setDisable(false);
        boardController.attackButton.setDisable(true);
        //Check if the player won a battle in attack phase,if true add a random card
    }

    public Player getPlayer(int i) {
        return players[i];
    }

    public int getState() {
        return state;
    }

    public  void setState(int state) {
        this.state = state;
    }

    public BoardController getController() { return boardController; }

}
