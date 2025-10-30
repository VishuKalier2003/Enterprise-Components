package chainofresponsibility.extreme.multioutcomechain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LoadBalancer {
    private final Map<String, Integer> load = new LinkedHashMap<>();

    public void updateLoad(String server, int loadValue) {
        load.put(server, loadValue);
    }

    public int getLoad(String server) {
        return load.getOrDefault(server, 0);
    }

    public void initiateLoad(String server) {this.load.put(server, 0);}

    public void show() {System.out.println(load);}
}
