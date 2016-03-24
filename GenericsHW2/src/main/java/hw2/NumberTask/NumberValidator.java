package hw2.NumberTask;


import hw2.ExecutorInterface.Validator;

public class NumberValidator implements Validator<Number> {

    public boolean isValid(Number result) {
        return (result.longValue() % 10 == 0);
    }
}
