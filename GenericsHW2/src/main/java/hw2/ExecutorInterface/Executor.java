package hw2.ExecutorInterface;


import java.util.List;

public interface Executor<T> {


    void addTask(Task task);


    void addTask(Task task, Validator<T> validator);


    void execute();


    List<T> getValidResults() throws IllegalStateException;

    List<T> getInvalidResults() throws IllegalStateException;
}