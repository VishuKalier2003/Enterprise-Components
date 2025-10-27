package chainofresponsibility.advance.policyrouting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Packet {
    private final LinkedHashMap<Integer, Chain> handlers;

    public Packet() {this.handlers = new LinkedHashMap<>();}

    public void addHandler(int index, Chain handler) {
        handlers.put(index, handler);
    }

    public Map<Integer, Chain> get() {return handlers;}
    public Chain get(int key) {return handlers.get(key);}

    public List<Chain> reorder() {
        List<Chain> handlerList = new ArrayList<>();
        for(Chain chain : handlers.values())
            handlerList.add(chain);
        Collections.sort(handlerList, (a,b) -> Integer.compare(a.getOrder(), b.getOrder()));
        return handlerList;
    }
}
