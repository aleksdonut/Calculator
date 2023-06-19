package pl.calculator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class MainController {

    @FXML
    private VBox vBox;

    @FXML
    private TextField mainTextArea;
    @FXML
    private Button zeroButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button fiveButton;
    @FXML
    private Button sixButton;
    @FXML
    private Button sevenButton;
    @FXML
    private Button eightButton;
    @FXML
    private Button nineButton;
    @FXML
    private MenuItem aboutMenuItem;
    @FXML
    private MenuItem closeMenuItem;
    @FXML
    private Menu historyMenu;
    @FXML
    private Button divideButton;
    @FXML
    private Button multiplicationButton;
    @FXML
    private Button subtractionButton;
    @FXML
    private Button addingButton;
    @FXML
    private Button doubleButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button percentButton;
    @FXML
    private Button sqrtButton;
    @FXML
    private Button sumButton;
    @FXML
    private Button valueButton;

    public void initialize() {
        pressedKey();
        keyboardInput();
        clearDesk();
        changeValue();
    }

    public void changeValue() {
        valueButton.setOnAction(actionEvent -> {
            if (!(mainTextArea.getText().isEmpty())) {
                if (mainTextArea.getText().startsWith("-")) {
                    mainTextArea.setText(mainTextArea.getText().replace("-", ""));
                } else {
                    mainTextArea.setText("-" + mainTextArea.getText());
                }
            }
        });
    }

    public void clearDesk() {
        clearButton.setOnAction(actionEvent -> mainTextArea.clear());
    }
    public void pressedKey() {
        zeroButton.setOnAction(actionEvent -> mainTextArea.setText(mainTextArea.getText() + zeroButton.getText()));
        oneButton.setOnAction(actionEvent -> mainTextArea.setText(mainTextArea.getText() + oneButton.getText()));
        twoButton.setOnAction(actionEvent -> mainTextArea.setText(mainTextArea.getText() + twoButton.getText()));
        threeButton.setOnAction(actionEvent -> mainTextArea.setText(mainTextArea.getText() + threeButton.getText()));
        fourButton.setOnAction(actionEvent -> mainTextArea.setText(mainTextArea.getText() + fourButton.getText()));
        fiveButton.setOnAction(actionEvent -> mainTextArea.setText(mainTextArea.getText() + fiveButton.getText()));
        sixButton.setOnAction(actionEvent -> mainTextArea.setText(mainTextArea.getText() + sixButton.getText()));
        sevenButton.setOnAction(actionEvent -> mainTextArea.setText(mainTextArea.getText() + sevenButton.getText()));
        eightButton.setOnAction(actionEvent -> mainTextArea.setText(mainTextArea.getText() + eightButton.getText()));
        nineButton.setOnAction(actionEvent -> mainTextArea.setText(mainTextArea.getText() + nineButton.getText()));
    }

    public void keyboardInput() {
       vBox.addEventFilter(KeyEvent.KEY_TYPED, keyEvent -> {
           if (keyEvent.getCharacter().matches("\\d*")) {
               mainTextArea.setText(mainTextArea.getText() + keyEvent.getCharacter());
           }
       });
    }
}