package ua.gojava.calculatorlib;

public class IntegerSubstractionOperator implements OperatorInterface<Integer> {
    public Integer evaluate(Integer a, Integer b) {
        return a - b;
    }
}
