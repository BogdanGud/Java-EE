package hw2.NumberTask;


import hw2.ExecutorInterface.Task;

public class LongTask implements Task<Long> {
    private long a;
    private Long result;

    public LongTask(long a) {
        this.a = a;
    }


    public Long getValue() {
        return a;
    }


    public void execute() {
        result = a / 10;
    }


    public Long getResult() {
        return result;
    }
}
