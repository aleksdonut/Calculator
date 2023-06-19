package pl.calculator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import pl.calculator.logic.CalculatorLogic;

public class MainController {
    private static final int ADD = 1;
    private static final int SUB = 2;
    private static final int MUL = 3;
    private static final int DIV = 4;
    private static final int SQRT = 5;
    private static final int PER = 6;


    CalculatorLogic calculatorLogic = new CalculatorLogic();
    private int operator = 0;


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
        add();
        subtract();
        multiply();
        divide();
        sqrt();
    }

    private int loadFirstValue() {
        if (!(mainTextArea.getText().isEmpty())) {
            int x = Integer.parseInt(mainTextArea.getText());
            mainTextArea.clear();
            return x;
        }
        return 0;
    }

    private void result(int x) {
        sumButton.setOnAction(actionEvent -> {
            if (!(mainTextArea.getText().isEmpty())) {
                int y = Integer.parseInt(mainTextArea.getText());
                switch (operator) {
                    case ADD:
                        mainTextArea.setText(Integer.toString(calculatorLogic.add(x, y)));
                        break;
                    case SUB:
                        mainTextArea.setText(Integer.toString(calculatorLogic.subtract(x, y)));
                        break;
                    case MUL:
                        mainTextArea.setText(Integer.toString(calculatorLogic.multiply(x, y)));
                        break;
                    case DIV:
                        mainTextArea.setText(Integer.toString(calculatorLogic.divide(x, y)));
                        break;
                    case SQRT:
                        mainTextArea.setText(Double.toString(calculatorLogic.sqrt(x)));
                    default:
                        break;
                }
            }
        });
    }

    private void sqrt() {
        sqrtButton.setOnAction(actionEvent -> {
            int x = loadFirstValue();
            mainTextArea.setText(Double.toString(calculatorLogic.sqrt(x)));
        });
    }

    private void divide() {
        divideButton.setOnAction(actionEvent -> {
            int x = loadFirstValue();
            operator = DIV;
            result(x);
        });
    }

    private void multiply() {
        multiplicationButton.setOnAction(actionEvent -> {
            int x = loadFirstValue();
            operator = MUL;
            result(x);
        });
    }

    private void add() {
        addingButton.setOnAction(actionEvent -> {
            int x = loadFirstValue();
            operator = ADD;
            result(x);
        });
    }

    private void subtract() {
        subtractionButton.setOnAction(actionEvent -> {
            int x = loadFirstValue();
            operator = SUB;
            result(x);
        });
    }

    private void changeValue() {
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

    private void clearDesk() {
        clearButton.setOnAction(actionEvent -> mainTextArea.clear());
    }

    private void pressedKey() {
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

    private void keyboardInput() {
        vBox.addEventFilter(KeyEvent.KEY_TYPED, keyEvent -> {
            if (keyEvent.getCharacter().matches("\\d*")) {
                mainTextArea.setText(mainTextArea.getText() + keyEvent.getCharacter());
            }
        });
    }
}