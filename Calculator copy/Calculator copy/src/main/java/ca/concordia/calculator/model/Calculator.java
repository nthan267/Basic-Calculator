package ca.concordia.calculator.model;

public class Calculator {

    private double currentValue = 0.0;
    public double getCurrentValue() {
        return currentValue;};

    public void multiply(double x){
        currentValue *= x;};

    public void add(double x){
      currentValue +=x;
    };

    public void subtract(double x){
        currentValue -=x;
    };

    public void divide(double x) {
    if (x==0){
        throw new ArithmeticException("Division by zero not allowed");
    };
    currentValue /= x;
    };

    public void set(double value) {
        currentValue = value;
    };

    public void clear() {
        currentValue = 0.0;
    };

};
