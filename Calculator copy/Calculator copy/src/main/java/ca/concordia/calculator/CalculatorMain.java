package ca.concordia.calculator;

import ca.concordia.calculator.controller.CalculatorController;
import ca.concordia.calculator.model.Calculator;
import ca.concordia.calculator.view.CalculatorView;


public class CalculatorMain {

    public static void main(String[] args) {
        Calculator model = new Calculator();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.start();
    }
}
