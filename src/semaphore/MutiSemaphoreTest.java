package semaphore;

public class MutiSemaphoreTest {
    public static void main(String[] args) {
        MultiPrinterQueue multiPrinterQueue = new MultiPrinterQueue();
        Thread thread[] = new Thread[10];

        for(int i=0; i<10; i++) {
            thread[i] = new Thread( new MultiPrinterJob(multiPrinterQueue), "thread " + i);
        }

        for(int i=0; i<10; i++) {
            thread[i].start();
        }
    }
}
