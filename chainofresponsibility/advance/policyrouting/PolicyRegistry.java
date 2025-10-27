package chainofresponsibility.advance.policyrouting;

import java.util.HashMap;
import java.util.Map;

public class PolicyRegistry {
    private final Map<String, PolicyEvaluator> registry;

    public PolicyRegistry() {
        this.registry = new HashMap<>();
        registry.put("ASC", PolicyEvaluator.ASCENDING);
        registry.put("DES", PolicyEvaluator.DESCENDING);
        registry.put("RAN", PolicyEvaluator.RANDOM);
    }

    public PolicyEvaluator accessRegistry(String key) {
        return registry.get(key);
    }
}
