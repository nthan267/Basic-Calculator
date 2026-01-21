package ca.concordia.calculator.controller;

import ca.concordia.calculator.model.Calculator;
import ca.concordia.calculator.view.CalculatorView;

public class CalculatorController {

    private final Calculator model;
    private final CalculatorView view;

    public CalculatorController(Calculator model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        boolean running = true;

        while (running) {
            view.showPrompt(model.getCurrentValue());
            String command = view.readCommand();

            try {
                if (command.equalsIgnoreCase("exit")) {
                    running = false;
                    view.showGoodbye();
                } else if (command.equalsIgnoreCase("clear")) {
                    model.clear();
                } else {
                    handleExpression(command);
                }
            } catch (Exception e) {
                view.showError(e.getMessage());
            }
        }
    }

    private void handleExpression(String input) {
        String[] tokens = input.split("\\s+");

        // Case 1: full expression: "5 + 3"
        if (tokens.length == 3) {
            double left = Double.parseDouble(tokens[0]);
            String operator = tokens[1];
            double right = Double.parseDouble(tokens[2]);

            model.set(left);
            applyOperation(operator, right);
            return;
        }

        // Case 2: relative expression: "+ 3"
        if (tokens.length == 2) {
            String operator = tokens[0];
            double value = Double.parseDouble(tokens[1]);

            applyOperation(operator, value);
            return;
        }

        throw new IllegalArgumentException("Invalid command format");
    }

    private void applyOperation(String operator, double value) {
        switch (operator) {
            case "+" -> model.add(value);
            case "-" -> model.subtract(value);
            case "*" -> model.multiply(value);
            case "/" -> model.divide(value);
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
