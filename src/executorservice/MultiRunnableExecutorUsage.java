package executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiRunnableExecutorUsage {

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);
        RejectedExecutionHandler rejectedExecutionHandler = new RejectionExecutionHandlerImpl();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,3,10, TimeUnit.SECONDS, workQueue);

        executor.prestartAllCoreThreads();
        List<Runnable> taskGroup = new ArrayList<>();
        taskGroup.add(new TaskOne());
        taskGroup.add(new TaskTwo());
        taskGroup.add(new TaskThree());

        workQueue.add(new MultiRunnable(taskGroup));

        executor.execute(new TaskOne());
        executor.execute(new TaskTwo());
        executor.execute(new TaskThree());

    }
}

class RejectionExecutionHandlerImpl implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        System.out.println(runnable.toString() + " : I have been rejected ! ");
    }
}

class MultiRunnable implements Runnable {

    private final List<Runnable> runnables;

    MultiRunnable(List<Runnable> runnables) {
        this.runnables = runnables;
    }

    @Override
    public void run() {
        for(Runnable runnable : runnables) {
            new Thread(runnable).start();
        }
    }
}

class TaskOne implements Runnable {

    @Override
    public void run() {
        System.out.println("Executing Task One ...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TaskTwo implements Runnable {

    @Override
    public void run() {
        System.out.println("Executing Task Two ...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TaskThree implements Runnable {

    @Override
    public void run() {
        System.out.println("Executing Task Three ...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


