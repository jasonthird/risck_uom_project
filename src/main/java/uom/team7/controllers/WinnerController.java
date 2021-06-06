package uom.team7.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

import static java.util.Objects.requireNonNull;

public class WinnerController {

    @FXML private Button okButton;

    @FXML
    public void okButton() throws IOException {
        String url ="https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
        //create a new stage
        Parent root;
        root = FXMLLoader.load(requireNonNull(StartMenuController.class.getResource("StartMenu.fxml")));
        stage.setScene(new Scene(root, 800, 600));
        stage.centerOnScreen();
        stage.show();
    }
}
