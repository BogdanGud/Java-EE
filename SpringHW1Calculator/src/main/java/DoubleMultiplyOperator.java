import ua.gojava.calculatorlib.*;

public class DoubleMultiplyOperator implements OperatorInterface<Double> {
    @Override
    public Double evaluate(Double a, Double b) {
        return a * b;
    }
}
