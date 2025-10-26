
import java.util.HashMap;
import java.util.Map;

public class MetricsManager {

    private static final Map<Integer, Double> loadMap = new HashMap<>();

    public static void init() {
        loadMap.put(1, 0.0d);
        loadMap.put(2, 0.0d);
        loadMap.put(3, 0.0d);
        loadMap.put(4, 0.0d);
        loadMap.put(5, 0.0d);
    }

    public static void get() {
        System.out.println("LOAD MAP : "+loadMap);
    }

    public static void update(Metrics metrics) {
        int id = MetricsCollector.extractHandlerID(metrics);
        loadMap.put(id, MetricsCollector.extractBalanceFactor(metrics));
    }

    public static void pushToBalancer() {
        for(Map.Entry<Integer, Double> e : loadMap.entrySet())
            LoadBalancer.push(e.getKey(), e.getValue());
    }
}
