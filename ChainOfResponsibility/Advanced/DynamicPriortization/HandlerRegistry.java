
import java.util.HashMap;
import java.util.Map;

public class HandlerRegistry {
    private static final Map<Integer, Handler> registry = new HashMap<>();

    public static void register(int index, Handler handler) {registry.put(index, handler);}

    public static Handler access(int index) {return registry.get(index);}
}
