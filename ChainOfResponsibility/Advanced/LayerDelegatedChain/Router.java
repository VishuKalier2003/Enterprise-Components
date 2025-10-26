
import java.util.HashMap;
import java.util.Map;

public class Router {
    private final Map<String, Chainable<?>> router;

    public Router() {
        this.router = new HashMap<>();
        router.put("PRESENTATION", null);
        router.put("SERVICE", null);
        router.put("TEST", null);
    }

    public <T extends Chainable<T>> T get(String key, Class<T> clazz) {
        Chainable value = router.get(key);
        if(clazz.isInstance(value))
            return clazz.cast(value);
        return null;
    }

    public <T extends Chainable<T>> void put(String key, T head) {
        router.put(key, head);
    }
}
