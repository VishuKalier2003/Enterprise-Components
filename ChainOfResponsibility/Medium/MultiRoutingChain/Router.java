import java.util.LinkedHashMap;
import java.util.Map;

public class Router {
    private static final Map<String, HandleX> ROUTER = new LinkedHashMap<>();

    public void addChain(String word, HandleX handle) {
        ROUTER.put(word, handle);
    }

    public HandleX getChain() {
        int value = (int)(Math.random()*ROUTER.size())+1;
        String chain = "Chain"+value;
        return ROUTER.get(chain);
    }

    public Map<String, HandleX> get() {return ROUTER;}
}
