package uom.team7;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class GameLogic {

    private  int state = 0, turn = 0;
    private boolean flag;
    private Scene scene;
    private final World world;
    private Player currentPlayer;
    private BoardController boardController;

    public GameLogic(int numPlayers, Stage stage) {

        //Game Data initialization
        world = new World(numPlayers);
        //Create a new stage
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Board.fxml"));
            root = fxmlLoader.load();
            scene = new Scene(root, 1024, 750);
            boardController = fxmlLoader.getController();
            boardController.updateMap(world.getPlayers(), scene);
            stage.setScene(scene);
            stage.alwaysOnTopProperty();
            start();
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Starts the Thread for the game loop
    private void start(){
        /* This Thread calculate's the current state of the current player.
           The input state change whenever the world updates on Users action.
           The loop ends when the win condition is achieved.In every 5 ms the Platform updates the
           Board. */
        new Thread(() -> {
            while (true) {
                try {
                    gameState();
                    // imitating work
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                // update Board Map on FX thread
                Platform.runLater(() -> drawMap(state));
            }
        }).start();
    }

    //Update map
    private void drawMap(int state){
        //Initial State
        if (state == 0) {
            boardController.placeTroops();
        }
        //FullHand State
        if( state == 6 && flag){
            boardController.fullHand(this);
        }
        //Upkeep State
        if (state == 1 || state == 2) {
            boardController.upkeep();
        }
        //Attack State
        if (state == 3) {
            boardController.attackPhase();
        }
        //EndTurn State
        if (state == 4) {
            boardController.endTurn();
        }
        boardController.init(this);
    }

    //Calculate the current state of the game and the current player
    private  void gameState(){
        currentPlayer = world.getPlayer(turn);
        if( currentPlayer.statusCheck()){
            if(currentPlayer == world.getPlayer(world.getPlayers().length-1)){
                turn = 0;
            }else {
                turn++;
            }
            currentPlayer = world.getPlayer(turn);
            state = 1;
        }
        if (state == 0) {
            if (currentPlayer == world.getPlayer(world.getPlayers().length-1) && currentPlayer.getUnsedTroops() == 0) {
                turn = 0;
                state = 1;
                currentPlayer = world.getPlayer(turn);
            } else if (currentPlayer.getUnsedTroops() == 0 && currentPlayer != world.getPlayer(world.getPlayers().length-1)) {
                turn++;
            }
        }
        if (state == 1) {
            currentPlayer.setWonCard(false);
            world.updateUnsedTroops(currentPlayer);
            if(currentPlayer.getCards().fullHandCheck()){
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
            currentPlayer.getCards().winCard(currentPlayer.isWonCard()); /// <----
            state = 1;
            if (currentPlayer == world.getPlayer(world.getPlayers().length-1)) {
                turn = 0;
            } else {
                turn++;
            }
        }
        if(state == 6  && !flag){
            state = 2;
        }
    }


                  /*Setters & Getters*/

    public World getWorld() { return world; }

    public void setFlag(boolean flag) { this.flag = flag; }

    public int getState() { return state; }

    public  void setState(int state) { this.state = state; }

    public BoardController getBoardController() { return boardController; }

    public Scene getScene() { return scene; }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isFlag() {
        return flag;
    }

}
