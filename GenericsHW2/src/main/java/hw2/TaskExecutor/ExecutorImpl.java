package hw2.TaskExecutor;


import hw2.ExecutorInterface.*;

import java.util.ArrayList;
import java.util.List;

class TaskValidatorContainer<T> {
    public Task<T> task;
    public Validator<T> validator;

    public TaskValidatorContainer(Task<T> task, Validator<T> validator) {
        this.task = task;
        this.validator = validator;
    }
}

public class ExecutorImpl<T> implements Executor {
    private boolean isExecuted = false;
    private List<TaskValidatorContainer<T>> tasks = new ArrayList<>();
    private List<T> validResults;
    private List<T> invalidResults;


    public void addTask(Task task) {
        if (isExecuted) throw new IllegalStateException();
        tasks.add(new TaskValidatorContainer<T>(task, null));
    }


    public void addTask(Task task, Validator validator) {
        if (isExecuted) throw new IllegalStateException();
        tasks.add(new TaskValidatorContainer(task, validator));
    }


    public void execute() {
        if (isExecuted) return;
        isExecuted = true;
        validResults = new ArrayList<>();
        invalidResults = new ArrayList<>();
        for (TaskValidatorContainer<T> task : tasks) {
            if (null == task.validator) {
                task.task.execute();
                validResults.add(task.task.getResult());
            } else {
                task.task.execute();
                if (task.validator.isValid(task.task.getValue())) {
                    validResults.add(task.task.getResult());
                } else {
                    invalidResults.add(task.task.getResult());
                }
            }
        }
    }

    private List<T> getResults(boolean isValid) throws IllegalStateException {
        if (!isExecuted) throw new IllegalStateException();
        if (isValid) {
            return validResults;
        } else {
            return invalidResults;
        }
    }


    public List<T> getValidResults() {
        return getResults(true);
    }


    public List<T> getInvalidResults() {
        return getResults(false);
    }

}
