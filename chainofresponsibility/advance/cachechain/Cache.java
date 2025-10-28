package chainofresponsibility.advance.cachechain;

import java.util.HashMap;
import java.util.Map;

public class Cache implements Cacheable {
    private static final Map<String, Integer> cache = new HashMap<>();

    public void register(CacheOutput output) {
        register(output.getReqID(), output.getIndex());
    }

    @Override public void register(String reqID, int statusCode) {
        cache.put(reqID, statusCode);
    }

    @Override public int get(String reqID) {
        if(cache.containsKey(reqID))
            return cache.get(reqID);
        return Integer.MAX_VALUE;
    }
}
