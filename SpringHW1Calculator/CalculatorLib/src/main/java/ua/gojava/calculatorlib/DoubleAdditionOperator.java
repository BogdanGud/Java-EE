package ua.gojava.calculatorlib;

public class DoubleAdditionOperator implements OperatorInterface<Double> {
    public Double evaluate(Double a, Double b) {
        return a + b;
    }
}
