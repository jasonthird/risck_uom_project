module uom.team7 {
    requires javafx.controls;
    requires javafx.fxml;

    opens uom.team7 to javafx.fxml;
    exports uom.team7;
}