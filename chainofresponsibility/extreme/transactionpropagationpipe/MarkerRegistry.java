package chainofresponsibility.extreme.transactionpropagationpipe;

import java.util.HashMap;
import java.util.Map;

public class MarkerRegistry {
    private final Map<String, Marker> registry = new HashMap<>();

    public void put(String s, Marker m) {this.registry.put(s, m);}
    public Marker get(String s) {return this.registry.get(s);}
}
