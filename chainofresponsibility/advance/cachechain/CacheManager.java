package chainofresponsibility.advance.cachechain;

public class CacheManager implements Runnable {
    private final Cache cache;
    private final CacheBus bus;

    public CacheManager(Cache cache, CacheBus bus) {
        this.cache = cache; this.bus = bus;
    }

    @Override
    public void run() {
        while (true) {
            CacheOutput output = bus.poll();  // blocks until item present
            int existing = cache.get(output.getReqID());
            if (existing == Integer.MAX_VALUE) {
                cache.register(output); // not cached → register new
                System.out.println("[CACHE] Registered new entry: " + output.getReqID());
            } else {
                System.out.println("[CACHE] Found existing: " + output.getReqID() + " = " + existing);
            }
        }
    }
}
