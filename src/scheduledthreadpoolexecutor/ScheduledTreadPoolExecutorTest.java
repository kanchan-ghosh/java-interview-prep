package scheduledthreadpoolexecutor;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTreadPoolExecutorTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        Task task1 = new Task("Demo Task 1");
        Task task2 = new Task("Demo Task 2");

        System.out.println("Current Time is " + Instant.now() + " By thread " + Thread.currentThread().getName());

        scheduledExecutorService.schedule(task1, 5, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(task2, 10, TimeUnit.SECONDS);

        try {
            scheduledExecutorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduledExecutorService.shutdown();
    }
}
