package hw2.ExecutorInterface;

public interface Task<T> {

    T getValue();

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();
}
