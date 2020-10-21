package thread;

public class PrintABCInThreeThread {

    static volatile int status = 1;

    public static void main(String[] args) {
        Object lock = new Object();

        A1 a1 = new A1(lock);
        B1 b1 = new B1(lock);
        C1 c1 = new C1(lock);

        a1.start();
        b1.start();
        c1.start();
    }

}

class A1 extends Thread {
    Object lock = null;

    public A1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (true) {
                    while (PrintABCInThreeThread.status != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    }
                    System.out.println("A ");
                    Thread.sleep(200);
                    PrintABCInThreeThread.status = 2;
                    lock.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception 1 : " + e.getMessage());
            e.printStackTrace();
        }
    }
}


class B1 extends Thread {
    Object lock = null;

    public B1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (true) {
                    while (PrintABCInThreeThread.status != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    }
                    System.out.println("B ");
                    Thread.sleep(200);
                    PrintABCInThreeThread.status = 3;
                    lock.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception 2 : " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class C1 extends Thread {
    Object lock = null;

    public C1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (true) {
                    while (PrintABCInThreeThread.status != 3) {
                        try {
                            lock.wait();
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    }
                    System.out.println("C ");
                    System.out.println("-------------");
                    Thread.sleep(1000);
                    PrintABCInThreeThread.status = 1;
                    lock.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception 3 : " + e.getMessage());
            e.printStackTrace();
        }
    }
}


