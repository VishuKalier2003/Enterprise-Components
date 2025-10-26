
import java.util.ArrayDeque;
import java.util.Deque;

public class RetryQueue {

    private static final Deque<Handle> QUEUE = new ArrayDeque<>();

    public boolean isEmpty() {
        return QUEUE.isEmpty();
    }

    public Handle poll() {
        return QUEUE.poll();
    }

    public void push(Handle handle) {
        QUEUE.offer(handle);
    }

    public void flush() {
        QUEUE.clear();
    }

    public Deque<Handle> get() {return QUEUE;}
}
