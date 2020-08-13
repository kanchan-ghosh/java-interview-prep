package scheduledthreadpoolexecutor;

import java.time.Instant;

public class Task implements Runnable {

    private final String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try{
            System.out.println("Working on task " + name + " , Time = " + Instant.now() + " By thread " + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
