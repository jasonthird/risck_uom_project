package uom.team7;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class GameLogic {

    private World world;
    private Player[] players;
    private Country[] countries;

    public GameLogic(int numPlayers,Scene scene) throws IOException {

        //Game initialization
        World world = new World(numPlayers);
        //close current stage
        Stage stage = (Stage) scene.getWindow();
        stage.close();
        //create a new stage
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXML/Board.fxml"));
            Stage board = new Stage();
            board.setTitle("RISK");
            board.setScene(new Scene(root, 1200, 900));
            board.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }


       /*
        //Board initialization
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("FXML/Board.fxml"));
        scene.setRoot(fxmlLoader.load());
        BoardController boardController = fxmlLoader.getController();

        */

    }

   public void upkeep(Player player){

        player.setWonCard(false);
        world.updateUnsedTroops(player);
        player.cards.fullHandCheck();
        while(player.getUnsedTroops() > 0) {




        }

   }

   public void attackPhase(Player player){

   }

   public void endTurn(Player player){

   }
}
