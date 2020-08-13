package executorservice;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

public class ShutdownDemo {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Instant now = Instant.now();
        System.out.printf("WorkerTasks scheduled at %s \n" , now);

        ScheduledFuture<String> result1 = scheduledExecutorService.schedule(new WorkerTask("Task1"),
                Duration.between(now, now.plusSeconds(10)).toSeconds(), TimeUnit.SECONDS );

        ScheduledFuture<String> result2 = scheduledExecutorService.schedule(new WorkerTask("Task2"),
                Duration.between(now, now.plusSeconds(20)).toSeconds(), TimeUnit.SECONDS );

        ScheduledFuture<String> result3 = scheduledExecutorService.schedule(new WorkerTask("Task3"),
                Duration.between(now, now.plusSeconds(30)).toSeconds(), TimeUnit.SECONDS );

        Thread.sleep(15_000);

        // scheduledExecutorService.shutdown();  // shutdown() will do graceful shutdown allowing all running task to complete
        scheduledExecutorService.shutdownNow();  // shutdownNow() will use Thread.interrupt to halt all running task and will do force termination

        System.out.println("Result 1 is done " + result1.isDone());
        System.out.println("Result 2 is done " + result2.isDone());
        System.out.println("Result 3 is done " + result3.isDone());

        System.out.println(" **************** Waiting for tasks to be complete ****************");

        scheduledExecutorService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println(" **************** All Tasks should be complete by now ****************");

        System.out.println("Result 1 is done " + result1.isDone());
        System.out.println("Result 2 is done " + result2.isDone());
        System.out.println("Result 3 is done " + result3.isDone());
    }
}

class WorkerTask implements Callable<String> {

    private final String name;

    WorkerTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("Worker Task %s executed on %s \n", name , Instant.now());
        return "Worker Task " + name + " is a success !!!";
    }
}
