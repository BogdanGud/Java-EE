package hw2;


import hw2.ExecutorInterface.*;
import hw2.NumberTask.*;
import hw2.TaskExecutor.*;


import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        List<Task<Integer>> intTasks = new ArrayList<>();
        intTasks.add(new IntTask(34));
        intTasks.add(new IntTask(35));
        intTasks.add(new IntTask(36));
        test(intTasks);
    }

    public static void test(List<Task<Integer>> intTasks) throws Exception {
        Executor<Number> numberExecutor = new ExecutorImpl<Number>();
        Validator numValidator = new NumberValidator();

        for (Task<Integer> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }

        numberExecutor.addTask(new LongTask(150L), new NumberValidator());
        numberExecutor.addTask(new LongTask(100500L), new NumberValidator());
        numberExecutor.addTask(new LongTask(2000L), new NumberValidator());
        numberExecutor.addTask(new LongTask(567L), new NumberValidator());
        numberExecutor.addTask(new LongTask(4660L), new NumberValidator());
        numberExecutor.addTask(new LongTask(2332L), new NumberValidator());
        numberExecutor.addTask(new LongTask(977L), new NumberValidator());
        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }
}
