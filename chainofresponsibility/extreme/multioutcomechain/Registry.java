package chainofresponsibility.extreme.multioutcomechain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Registry {
    private final Map<String, Model> modelMap = new LinkedHashMap<>();

    public void register(String id, Model m) {this.modelMap.put(id, m);}
    public Model getModel(String id) {return this.modelMap.get(id);}

    public void show() {System.out.println(modelMap);}
}
