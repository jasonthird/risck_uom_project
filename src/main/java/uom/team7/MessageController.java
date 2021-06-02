package uom.team7;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MessageController implements Initializable {
    @FXML private Button troopLabel;
    @FXML private Slider slider;
    @FXML private Label countryLabel,countryLabel1,conquerLabel,fortifyLabel;
    private Player player;
    private BoardController board;
    private Scene scene;
    private World world;
    private Country country,country2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        slider.valueProperty().addListener((observableValue, number, t1) -> troopLabel.setText(String.valueOf((int)slider.getValue())));
    }

    @FXML
    public void fortify() throws IOException {
        board.oneSelected = false;
        board.twoSelected = false;
        world.moveArmy(country,country2,(int)slider.getValue(),player);
        System.out.println(country.getNumTroops() + "  " + country2.getNumTroops());
        board.updateMap(world.getPlayers(), scene);
        Stage stage = (Stage) troopLabel.getScene().getWindow();
        stage.close();
    }

    //Initialize the values of scene's components
    public void init(Country country, Country country2, World world, Player player, BoardController boardController, Scene scene) {
        this.scene =scene;
        this.board =boardController;
        this.player = player;
        this.world = world;
       this.country = country;
       this.country2 = country2;
        slider.setMax(country.getNumTroops() - 1);
        slider.setMin(0);
        slider.setValue(0);
        troopLabel.setText("0");
        if(conquerLabel != null) {
            conquerLabel.setStyle("-fx-text-fill:" + player.getColor());
        }
        if(fortifyLabel != null) {
            fortifyLabel.setStyle("-fx-text-fill:" + player.getColor());
        }
        if(countryLabel1 != null) {
            countryLabel1.setText(country2.toString());
        }
        if(countryLabel != null) {
            countryLabel.setText(country2.toString());
        }
    }
}
