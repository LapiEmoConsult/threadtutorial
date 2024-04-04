public class ThreadExample {

    public static void main(String[] args) {
        // 1st
        MyThread myThread = new MyThread("myThread");
        myThread.start();

        // 2nd
        MyTask myTask = new MyTask();
        Thread threadTask = new Thread(myTask, "threadTask");
        threadTask.start();

        // 3rd
        Runnable myRunnable = () -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        };
        Thread threadRunnable = new Thread(myRunnable, "threadRunnable");
        threadRunnable.start();
    }
}
