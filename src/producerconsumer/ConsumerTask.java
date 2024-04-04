package producerconsumer;

public class ConsumerTask implements Runnable {

    private final SharedResource sharedResource;

    public ConsumerTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (true) {
            if (sharedResource.isEmpty() && sharedResource.isFinished()) {
                long end = System.currentTimeMillis();
                System.out.printf("[Time] - %s took %s \n", Thread.currentThread().getName(), (end - start));
                return;
            }
            Integer item = sharedResource.getItem();
            MyService.process(item);
        }
    }
}
