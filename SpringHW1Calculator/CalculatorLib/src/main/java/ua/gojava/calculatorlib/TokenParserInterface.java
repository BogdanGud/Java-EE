package ua.gojava.calculatorlib;

public interface TokenParserInterface<T> {
    T parserFromString (String token);
}
