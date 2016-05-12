package ua.gojava.calculatorlib;

public class IntegerParser implements TokenParserInterface<Integer> {
    @Override
    public Integer parserFromString(String token) {
        return Integer.parseInt(token);
    }
}
