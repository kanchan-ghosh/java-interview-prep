package semaphore.binarysemaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue();
        Thread[] threads = new Thread[10];
        for(int i=0; i<10; i++) {
            threads[i] = new Thread(new PrinterJob(printerQueue), "Thread " + i);
        }
        for(int i=0; i<10; i++) {
            threads[i].start();
        }
    }
}
