package ua.gojava.calculatorlib;

import java.util.LinkedList;

public class PolishMathParser<T> extends MathParser<T> {

    private TokenParserInterface<T> tokenParser;
    public PolishMathParser(TokenParserInterface<T> tokenParser ) {
        this.tokenParser = tokenParser;
    }

    @Override
    public T calculate(String statement) {
        String cleanExpr = cleanExpr(statement);
        LinkedList<T> stack = new LinkedList<T>();

        for (String tokenString : cleanExpr.split("\\s")) {
            T token = null;
            try {
                token = tokenParser.parserFromString(tokenString);
            } catch (NumberFormatException e) {}

            if (token != null) {
                stack.push(token);
            } else {
                OperatorInterface<T> operator = findOperator(tokenString);
                T secondOperand = stack.pop();
                T firstOperand = stack.pop();
                stack.push(operator.evaluate(firstOperand , secondOperand));
            }
        }
        T result = stack.pop();
        return result;
    }

    private String cleanExpr(String expr) {
        return expr.replaceAll("[^\\^\\*\\+\\-\\d/\\s\\.]", "");
    }
}
