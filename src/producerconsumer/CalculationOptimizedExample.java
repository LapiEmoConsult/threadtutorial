package producerconsumer;

import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CalculationOptimizedExample {

    public static void main(String[] args) {
        Stream<Integer> intStream = Stream.of(50, 150, 30, 65, 45, 78, 90, 55, 35, 95);
        SharedResource sharedResource = new SharedResource();

        ProducerTask producerTask = new ProducerTask(sharedResource, intStream);
        ConsumerTask consumerTask = new ConsumerTask(sharedResource);

        Thread tProducer = new Thread(producerTask, "Producer");
        Thread tConsumer = new Thread(consumerTask, "Consumer");

        tConsumer.start();
        tProducer.start();

        Map<String, String> map = new LinkedHashMap<>();
        while (true) {
            String state = tConsumer.getState().toString();
            map.putIfAbsent(state, LocalTime.now().toString());
            if (map.containsKey("TERMINATED")) {
                map.forEach((key, value) -> System.out.printf("%s - %s \n", value, key));
                break;
            }
        }
    }
}
