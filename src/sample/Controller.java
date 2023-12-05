package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label display;

    private String currentInput = "";
    private double result = 0;
    private String operator = "";

    @FXML
    private void handleDigitClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        if (display.getText().equals("0") && clickedButton.getText().equals("0"))
            return;
        currentInput += clickedButton.getText();
        display.setText(currentInput);
    }

    @FXML
    private void handleOperatorClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String clickedOperator = clickedButton.getText();

        if (!currentInput.isEmpty()) {
            if (!operator.isEmpty()) {
                result = performOperation();
                display.setText(String.valueOf(result));
            } else {
                result = Double.parseDouble(currentInput);
            }

            currentInput = "";
            operator = clickedOperator;
        }
    }

    @FXML
    private void handleEqualsClick() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            result = performOperation();
            display.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            operator = "";
        }
    }

    @FXML
    private void handleClearClick() {
        currentInput = "";
        result = 0;
        operator = "";
        display.setText("");
    }

    private double performOperation() {
        double operand = Double.parseDouble(currentInput);
        switch (operator) {
            case "+":
                return result + operand;
            case "-":
                return result - operand;
            case "*":
                return result * operand;
            case "/":
                if (operand != 0) {
                    return result / operand;
                } else {
                    // Handle division by zero
                    return 0;
                }
            case "%":
                return result % operand;
            default:
                return operand;
        }
    }
}
