package chainofresponsibility.extreme.multiphasechain;

import java.util.HashMap;
import java.util.Map;

public class PhaseRegistry {
    private final Map<Phaser, Phaser> manager;

    public PhaseRegistry() {this.manager = new HashMap<>();}

    public void connectPhases(Phaser from, Phaser to) {
        this.manager.put(from, to);
    }

    public Phaser nextPhase(Phaser current) {return this.manager.get(current);}
    public void finalPhase(Phaser finalPhase) {this.manager.put(finalPhase, null);}
}
