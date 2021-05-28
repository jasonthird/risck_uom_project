package uom.team7;


import java.io.IOException;
import java.net.URL;
import java.text.BreakIterator;
import java.util.ResourceBundle;


import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BoardController  {
    private Country country,country2;
    private World world;
    private Player player;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public boolean twoSelected = false;
    public String buttonId, buttonText,buttonId2, buttonText2;
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
    }

    @FXML
    private void skipButton() throws IOException {
    }

    @FXML
    private void tradeCardsButton() throws IOException {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXML/TradeCards.fxml"));
            Stage stage = new Stage();
            stage.setTitle("RISK");
            stage.setScene(new Scene(root, 300, 370));
            stage.setResizable(false);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.centerOnScreen();
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
            country = world.findCountry(buttonId);
            if (player.countriesOwned.contains(country)) {
                    System.out.println("Country: " + country.toString() + ", Troops: " + country.getNumTroops());

            }

        }
        //attack phase handler
        else if (tradeButton.isDisable()) {
            if (!twoSelected) {
                buttonId = button.getId().toString();
                buttonText = button.getText();
                country = world.findCountry(buttonId);
                twoSelected = true;
            } else {
                buttonId = button.getId().toString();
                buttonText = button.getText();
                country2 = world.findCountry(buttonId);
                if (player.countriesOwned.contains(country) && !player.countriesOwned.contains(country2) ) {
                    if(world.listOfConnectedCountries(country,player).contains(country2)) {
                        System.out.println("Player: " + player.id + " Attack: " + country2.toString() + " /From: " + country.toString());
                    }
                }
                twoSelected = false;

            }
        }



        //Endturn handler
        else if (attackButton.isDisable()) {
            if (!twoSelected) {
                buttonId = button.getId().toString();
                buttonText = button.getText();
                country = world.findCountry(buttonId);
                twoSelected = true;
            } else {
                buttonId = button.getId().toString();
                buttonText = button.getText();
                country2 = world.findCountry(buttonId);

                if (player.countriesOwned.contains(country) && player.countriesOwned.contains(country2) && country != country2 ) {

                       if (country.adjacentCountries.contains(country2)){
                           System.out.println("Player: "+ player.id + " Fortify: " + country2.toString() + " /From: " + country.toString());
                       }


                }
                twoSelected = false;

            }
        }
    }
    public void init(Player player,World world){
        this.player = player;
        this.world = world;
    }
    public void initCountriesWithButtons(Player[] players, Scene scene) {
        for (Player p : players) {
            for (Country c : p.countriesOwned) {
                Button b = (Button) scene.lookup("#" + c.toString());
                b.setText(String.valueOf((c.getNumTroops())));
                b.setStyle("-fx-background-color:" + p.getColor());
            }
        }
    }

}


