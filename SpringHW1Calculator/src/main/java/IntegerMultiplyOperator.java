import ua.gojava.calculatorlib.*;

public class IntegerMultiplyOperator implements OperatorInterface<Integer> {
    @Override
    public Integer evaluate(Integer a, Integer b) {
        return a * b;
    }
}
