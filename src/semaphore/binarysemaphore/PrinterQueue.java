package semaphore.binarysemaphore;

import java.util.concurrent.Semaphore;

public class PrinterQueue {
    private final Semaphore semaphore;

    public PrinterQueue() {
        semaphore = new Semaphore(1);
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();

            long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() +  " Printing job for " + duration/1000 + " seconds.");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(Thread.currentThread().getName() +  " completed its print job ");
            semaphore.release();
        }
    }
}
