package scheduledthreadpoolexecutor;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorPeriodicTest {
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Task task1 = new Task("Demo task 1");
        System.out.println("The time is " + Instant.now() + " By thread " + Thread.currentThread().getName());

        ScheduledFuture<?> result = scheduledExecutorService.scheduleAtFixedRate(task1, 2, 5, TimeUnit.SECONDS);

        try {
            TimeUnit.MILLISECONDS.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduledExecutorService.shutdown();
    }
}
