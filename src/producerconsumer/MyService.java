package producerconsumer;

public class MyService {

    public static Integer buildItem(int elt) {
        System.out.println("MyService - building item: " + elt);
        try {
            Thread.sleep(300);
        } catch (InterruptedException ignored) {}
        return elt;
    }

    public static void process(Integer item) {
        System.out.println("MyService - processing item: " + item);
        try {
            Thread.sleep(700);
        } catch (InterruptedException ignored) {}
    }
}
