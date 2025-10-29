package chainofresponsibility.extreme.multiphasechain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class LambdaRegistry {
    private final Map<Linkable, Function<Data, Data>> registry;

    public LambdaRegistry() {
        this.registry = new HashMap<>();
    }

    public void register(Linkable handler, Function<Data, Data> function) {
        this.registry.put(handler, function);
    }

    public Function<Data, Data> getFunction(Linkable handler) {
        return this.registry.get(handler);
    }

    public Data execute(Linkable handler, Data data) {
        Function<Data, Data> function = registry.get(handler);
        if (function == null) {
            throw new IllegalStateException("No lambda registered for " + handler);
        }
        Data result = function.apply(data);
        if (result == null) {
            throw new IllegalStateException(handler + " returned null data!");
        }
        return result;
    }

}
