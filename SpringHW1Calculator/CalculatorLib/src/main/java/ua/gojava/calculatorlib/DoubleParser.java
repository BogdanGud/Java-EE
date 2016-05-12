package ua.gojava.calculatorlib;

public class DoubleParser implements TokenParserInterface<Double> {
    @Override
    public Double parserFromString(String token) {
        return Double.parseDouble(token);
    }
}
