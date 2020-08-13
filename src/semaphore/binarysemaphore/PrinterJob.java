package semaphore.binarysemaphore;

public class PrinterJob implements Runnable {

    private final PrinterQueue printerQueue;

    public PrinterJob(PrinterQueue printerQueue) {
        this.printerQueue = printerQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s : Going to print a doc \n", Thread.currentThread().getName() );
        printerQueue.printJob(new Object());
    }
}
