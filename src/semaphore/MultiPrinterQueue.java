package semaphore;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiPrinterQueue {

    private final Semaphore semaphore;
    private final Lock printerLock;
    private boolean freePrinters[];


    public MultiPrinterQueue() {
        semaphore = new Semaphore(3);
        printerLock = new ReentrantLock();
        freePrinters = new boolean[3];
        Arrays.fill(freePrinters, true);
    }

    public void printJob(Object document) {
        try{
            // Decrease the semaphore to acquire a printer.
            semaphore.acquire();
            int assignedPrinter = getPrinter();

            Long duration = (long)(Math.random() * 10000);
            System.out.println( Thread.currentThread().getName() +  " : Printer = " + assignedPrinter
                + " : Print job duration : " + duration/1000 + " seconds ");
            Thread.sleep(duration);
            releasePrinter(assignedPrinter);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " finished its print job");
            semaphore.release();
        }

    }

    private int getPrinter() {
        int foundPrinter = -1;

        try {
            // get a lock so that only thread can go beyod this.
            printerLock.lock();

            for(int i=0; i<freePrinters.length; i++) {
                if(freePrinters[i]) {
                    foundPrinter = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            printerLock.unlock();
        }
        return foundPrinter;
    }

    private void releasePrinter(int i) {
        printerLock.lock();
        freePrinters[i] = true;
        printerLock.unlock();
    }
}
