package ua.gojava.calculatorlib;

import java.util.HashMap;
import java.util.Map;

public abstract class MathParser<T> {

    private Map<String, OperatorInterface<T>> operatorsMap = new HashMap<String, OperatorInterface<T>>();

    public void registerOperator(String sign, OperatorInterface<T> operator){
        operatorsMap.put(sign, operator);
    }

    protected OperatorInterface<T> findOperator (String sign){
        OperatorInterface<T> result = operatorsMap.get(sign);
        if (result == null) {
            throw new IllegalArgumentException("Unknown operator : " + sign);
        }
        return result;
    }

    public abstract T calculate(String statement);
}
