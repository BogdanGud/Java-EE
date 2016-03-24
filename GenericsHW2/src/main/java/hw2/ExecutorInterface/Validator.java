package hw2.ExecutorInterface;


public interface Validator<T> {

    // Валидирует переданое значение
    boolean isValid(T result);

}