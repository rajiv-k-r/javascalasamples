package exp.rkr.threads;

public class ThreadNamePrinter {

    public static void main(String[] args) throws Exception {
        MyThread obj = new MyThread();
        Object lock = obj.getObject();
        synchronized(lock) {
            Thread t1 = new Thread(obj);
            Thread t2 = new Thread(obj);
            t1.start();
            //Thread.sleep(1000);
            t2.start();
        }
    }

}

class MyThread implements Runnable {
    private final Object lock = new Object();
    private int counter;
    @Override
    public void run() {
        try {
            for(int i = 0; i < 5; i++) {
                synchronized (lock) {
                    counter++;
                    System.out.println("counter: " + counter + ", Thread name: " + Thread.currentThread().getName());
                    lock.notify();
                    lock.wait();
                }
            }
            System.out.println("for loop complete for thread: " + Thread.currentThread().getName());
            synchronized (lock) {
                lock.notify();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public Object getObject() {
        return lock;
    }
}
