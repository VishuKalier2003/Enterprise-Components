package chainofresponsibility.advance.feedbackloop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LoadRegister {
    private static final Map<Integer, Integer> loadMap = new LinkedHashMap<>();
    private static final Map<Integer, Boolean> stateMap = new LinkedHashMap<>();

    public static void updateLoad(int key, int value) {
        if(!loadMap.containsKey(key)) {
            stateMap.put(key, false);
            loadMap.put(key, value);
        } else
            loadMap.put(key, loadMap.get(key) + value);
    }

    public static boolean getState(int key) {return stateMap.get(key);}
    public static void setState(int key) {stateMap.put(key, true);}

    public static void show() {System.out.println("Load Map : "+loadMap); System.out.println("State Map : "+stateMap);}

    public static int getLoad(int key) {return loadMap.get(key);}

    public static List<int[]> getAbstractLoadMap() {
        List<int[]> mp = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : loadMap.entrySet())
            mp.add(new int[]{e.getKey(), e.getValue()});
        return mp;
    }
}
