
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Delegator {
    private final List<String> executors;
    private final Map<String, Class> mapper;

    public Delegator() {
        this.executors = new ArrayList<>();
        executors.add("PRESENTATION");
        executors.add("SERVICE");
        executors.add("TEST");
        this.mapper = new HashMap<>();
        mapper.put("PRESENTATION", PresentationChain.class);
        mapper.put("SERVICE", ServiceChain.class);
        mapper.put("TEST", TestChain.class);
    }

    public String get(int index) {return executors.get(index);}
    public Class getValue(int index) {return mapper.get(get(index));}
    public boolean isEnd(int index) {return executors.size() == index;}
}
