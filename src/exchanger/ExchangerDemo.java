package exchanger;


import java.util.concurrent.Exchanger;

/**
 * Exchanger is used for communication between two thread
 * This class is used to exchange data between two threads. An Exchanger waits until both the threads call its
 * exchange() method and when this method is invoked, the exchanger exchanges data between two threads.
 * It uses method exchange for exchanging data .
 *
 *  It has two version of exchange method given below :
 *
 *     V exchange(V x): This method will wait until other thread calls exchange method or interrupts it. When other
 *     thread calls exchange method then waiting thread resumed and data exchanging is done between two threads.
 *
 *     V exchange(V x, long timeout, TimeUnit unit) : This method will wait until other thread calls exchange method
 *     or interrupts it or specified time elapses. . When other thread calls exchange method then waiting thread
 *     resumed and data exchanging is done between two threads.
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ProducerBuffer producerBuffer = new ProducerBuffer(exchanger);
        ConsumerBuffer consumerBuffer = new ConsumerBuffer(exchanger);

        Thread prodThread = new Thread(producerBuffer, "prodThread");
        Thread consThread = new Thread(consumerBuffer, "consThread");

        prodThread.start();
        consThread.start();
    }
}

class ProducerBuffer implements Runnable {
    Exchanger<String> exchanger;
    String message;

    public ProducerBuffer(Exchanger<String> exchanger) {
        message = new String();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            message += i;
            System.out.println("Producer generated message " + message);
            try {
                message = exchanger.exchange(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerBuffer extends Thread {

    Exchanger<String> exchanger;
    String message;

    public ConsumerBuffer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            try {
                message = exchanger.exchange(new String());
                System.out.println("Consumer consumed message " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}