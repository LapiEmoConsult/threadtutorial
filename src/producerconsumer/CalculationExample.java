package producerconsumer;

import java.util.stream.Stream;

public class CalculationExample {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Stream.of(50, 150, 30, 65, 45, 78, 90, 55, 35, 95)
                .map(MyService::buildItem)
                .forEach(MyService::process);

        long end = System.currentTimeMillis();
        System.out.println("[Time without optimization] - It took: " + (end - start));
    }
}
