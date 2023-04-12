package lab3.Task9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {

        Runnable[] tasks = generateTasks(10);

        System.out.println("Together:");
        runTogether(tasks);

        System.out.println("------------------------------------------------------");

        System.out.println("In order:");
        runInOrder(tasks);
    }

    private static Runnable[] generateTasks(int count) {
        List<Runnable> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int x = i;
            list.add(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.print(x+" ");
                }
                System.out.println();
            });
        }

        return list.toArray(new Runnable[]{});
    }
    public static void runTogether(Runnable... tasks) {
        try (ExecutorService exec = Executors.newFixedThreadPool(tasks.length)) {
            for (Runnable task : tasks) {
                exec.execute(task);
            }
            exec.shutdown();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }
}
