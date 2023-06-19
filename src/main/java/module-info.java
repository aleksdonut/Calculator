module Calculator {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports pl.calculator.main;

    opens pl.calculator.controller to javafx.fxml;
}