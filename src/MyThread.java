public class MyThread extends Thread {

    public MyThread(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }

}
