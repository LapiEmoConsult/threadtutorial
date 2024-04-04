package producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private final Queue<Integer> queue = new LinkedList<>();
    private volatile boolean isFinished = false;
    public synchronized Integer getItem() {
        if (isEmpty()) {
            try {
                System.out.printf("%s is waiting...\n", Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {}
        }

        Integer eltRemoved = queue.remove();
        System.out.printf("%s - processing: %s.\n", Thread.currentThread().getName(), eltRemoved);

        return eltRemoved;
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    public synchronized void add(Integer elt) {
        boolean wasEmpty = queue.isEmpty();
        queue.add(elt);
        System.out.printf("%s - added: %s.\n", Thread.currentThread().getName(), elt);

        if (wasEmpty) {
            System.out.println("Notify waiting thread.");
            notify();
        }
    }

    public void markAsFinish() {
        this.isFinished = true;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
