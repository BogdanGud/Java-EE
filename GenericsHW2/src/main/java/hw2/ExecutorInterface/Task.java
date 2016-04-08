package hw2.ExecutorInterface;

public interface Task<T> {

    T getValue();


    void execute();


    T getResult();
}
