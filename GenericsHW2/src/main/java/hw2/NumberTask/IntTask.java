package hw2.NumberTask;


import hw2.ExecutorInterface.Task;


public class IntTask implements Task {
    private int a;
    private Integer result;

    public IntTask(int a) {
        this.a = a;
    }


    public Object getValue() {
        return a;
    }


    public void execute() {
        result = a / 10;
    }


    public Object getResult() {
        return result;
    }
}
