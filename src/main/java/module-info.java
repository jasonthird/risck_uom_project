module uom.team7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens uom.team7 to javafx.fxml;
    exports uom.team7;
    exports uom.team7.model;
    opens uom.team7.model to javafx.fxml;
    exports uom.team7.controllers;
    opens uom.team7.controllers to javafx.fxml;
}