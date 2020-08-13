package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoExecutorUsage {

    private static ExecutorService executorService = null;
    private static volatile Future testOneResults = null;
    private static volatile Future testTwoResults = null;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(2);
        try {
            checkTasks();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exceptions occured " + e.getMessage());
            e.printStackTrace();
        }

    }

    private static void checkTasks() throws Exception {
        if(testOneResults == null || testOneResults.isDone() || testOneResults.isCancelled()) {
            testOneResults = executorService.submit(new TestOne());
        }
        if(testTwoResults == null || testTwoResults.isDone() || testTwoResults.isCancelled()) {
            testTwoResults = executorService.submit(new TestTwo());
        }
    }
}

class TestOne implements Runnable {

    @Override
    public void run() {
        while(true) {
            System.out.println("Executing TestOne job...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TestTwo implements Runnable {

    @Override
    public void run() {
        while(true) {
            System.out.println("Executing TestTwo job...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
