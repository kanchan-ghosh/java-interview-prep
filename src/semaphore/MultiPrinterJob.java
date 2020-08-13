package semaphore;

public class MultiPrinterJob implements Runnable {
    private final MultiPrinterQueue multiPrinterQueue;

    public MultiPrinterJob(MultiPrinterQueue multiPrinterQueue) {
        this.multiPrinterQueue = multiPrinterQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s : Going to print a doc \n", Thread.currentThread().getName() );
        multiPrinterQueue.printJob(new Object());
    }
}
