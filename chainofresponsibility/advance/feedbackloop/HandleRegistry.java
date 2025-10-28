package chainofresponsibility.advance.feedbackloop;

import java.util.HashMap;
import java.util.Map;

public class HandleRegistry {
    private static final Map<Integer, Handler> registry = new HashMap<>();

    public static void put(int key, Handler value) {registry.put(key, value);}

    public static Handler get(int key) {
        if(registry.containsKey(key))
            return registry.get(key);
        return null;
    }
}
