package chainofresponsibility.advance.cachechain;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class CacheBus implements Callable<CacheOutput> {
    private static final BlockingQueue<CacheOutput> queue = new ArrayBlockingQueue<>(10);

    public static void bus(CacheOutput data) {queue.add(data);}

    public CacheOutput poll() {
        return call();
    }

    @Override public CacheOutput call() {
        try {
            return queue.take();
        } catch(InterruptedException e) {
            e.getLocalizedMessage();
            return null;
        }
    }
}
