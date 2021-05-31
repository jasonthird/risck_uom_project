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


public class BoardController  {
    private Scene scene1;
    private Country country,country2;
    private GameLogic game;
    private World world;
    private Player player;
    public boolean twoSelected = false;
    public String buttonId, buttonText;

    @FXML
    public Button closeButton, attackButton, skipButton, tradeButton;
    @FXML
    public Label playerLabel, unsedTroopsLabel, upkeepLabel, fortifyLabel;


    @FXML
    private void switchToStartMenu() throws IOException {
        //close current stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        //create a new stage
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXML/StartMenu.fxml"));
            stage.setScene(new Scene(root, 800, 600));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void attackButton() throws IOException {
        //Sets the attackButton disable again
        attackButton.setStyle("-fx-background-color: #bd1111");
        attackButton.setDisable(true);

        System.out.println("Player:"+player.id+" Attack: "+country2.toString()+"/From: "+country.toString());

        if(world.attack(country,country2)) {
            Parent root;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Victory.fxml"));
                root = fxmlLoader.load();
                MessageController messageController = fxmlLoader.getController();
                messageController.init(country,country2,world,player,this,scene1);
                updateMap(world.getPlayers(), scene1);
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
        if(world.checkWin(world.getPlayers())){
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("FXML/WinnerMessage.fxml"));
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
        updateMap(world.getPlayers(), scene1);
    }

    @FXML
    private void skipButton() throws IOException {
        game.setState(game.getState() + 1);
    }

    @FXML
    private void tradeCardsButton() throws IOException {

        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/TradeCards.fxml"));
            root = fxmlLoader.load();
            TradeCardsController tradeCardsController = fxmlLoader.getController();
            tradeCardsController.init(player,this,world);
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
        if (skipButton.isDisable()) {
            buttonId = button.getId().toString();
            buttonText = button.getText();
            Country country = game.fortify(buttonId,player,world);
            button.setText(String.valueOf(country.getNumTroops()));
            unsedTroopsLabel.setText("x" + player.getUnsedTroops());
        }

        //attack phase handler
        else if (tradeButton.isDisable()) {
            buttonId = button.getId().toString();
            buttonText = button.getText();
            if (!twoSelected) {
                country = world.findCountry(buttonId);
                System.out.println("Selected Country:" + country.toString());
                twoSelected = true;
            } else {
                country2 = world.findCountry(buttonId);
                System.out.println("Selected Country:" + country2.toString());
                if (world.attackCheck(country,country2,player)) {
                        attackButton.setStyle("-fx-background-color: #0fea88");
                        attackButton.setDisable(false);
                    twoSelected = false;
                }else{
                    twoSelected = false;
                }

            }
        }

        //Endturn handler
        else if (attackButton.isDisable()) {
            buttonId = button.getId().toString();
            buttonText = button.getText();
            if (!twoSelected) {
                country = world.findCountry(buttonId);
                System.out.println("Selected Country:" + country.toString());
                twoSelected = true;
            } else {
                country2 = world.findCountry(buttonId);
                System.out.println("Selected Country:" + country2.toString());
                if(     world.moveArmyCheck(country,country2,player) ) {
                    Parent root;
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Fortify.fxml"));
                        root = fxmlLoader.load();
                        MessageController messageController = fxmlLoader.getController();
                        messageController.init(country,country2,world,player,this,scene1);
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
                twoSelected = false;
            }
        }
    }

    public void init(GameLogic gameLogic,int i, Scene scene){
        game = gameLogic;
        this.player = gameLogic.getPlayer(i);
        this.world = gameLogic.world;
        scene1 = scene;
        playerLabel.setStyle("-fx-text-fill:" + player.getColor());
        playerLabel.setText("PLAYER " + player.id);
        unsedTroopsLabel.setText("x" + player.getUnsedTroops());
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
}


