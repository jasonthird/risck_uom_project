package uom.team7;


import java.awt.event.ActionEvent;
import java.io.IOException;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BoardController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public Button closeButton;


    @FXML
    private void switchToStartMenu() throws IOException {
        //close current stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        //create a new stage
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXML/StartMenu.fxml"));
            Stage board = new Stage();
            board.setTitle("RISK");
            board.setScene(new Scene(root, 800, 600));
            board.setResizable(false);
            board.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
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
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }



}
