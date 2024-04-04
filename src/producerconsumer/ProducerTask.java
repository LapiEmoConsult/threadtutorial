package producerconsumer;

import java.util.stream.Stream;

public class ProducerTask implements Runnable {
    private final SharedResource sharedResource;
    private final Stream<Integer> intStream;

    public ProducerTask(SharedResource sharedResource, Stream<Integer> intStream) {
        this.sharedResource = sharedResource;
        this.intStream = intStream;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        intStream.forEach(item -> {
            Integer i = MyService.buildItem(item);
            sharedResource.add(i);
        });

        sharedResource.markAsFinish();
        long end = System.currentTimeMillis();

        System.out.printf("[Time] - %s took %s \n", Thread.currentThread().getName(), (end - start));
    }
}
