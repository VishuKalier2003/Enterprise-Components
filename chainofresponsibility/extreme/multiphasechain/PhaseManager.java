package chainofresponsibility.extreme.multiphasechain;

public class PhaseManager {

    public void initiateChain(Phaser phaser, Data[] data, LambdaRegistry lr, PhaseRegistry pr) {
        int idx = 0;
        while(phaser != null) {
            phaser.initiate(data[idx++], lr);
            phaser = pr.nextPhase(phaser);
        }
    }
}
