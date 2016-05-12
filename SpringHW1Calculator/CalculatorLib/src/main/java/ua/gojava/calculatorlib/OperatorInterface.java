package ua.gojava.calculatorlib;

public interface OperatorInterface<T> {
    T evaluate(T a, T b);
}
