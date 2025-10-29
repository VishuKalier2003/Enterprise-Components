package chainofresponsibility.extreme.multiphasechain;

public class Test {
    public static void main(String[] args) {
        PhaseManager pm = new PhaseManager();
        PhaseRegistry pr = new PhaseRegistry();
        LambdaRegistry lr = new LambdaRegistry();
        Data data1 = new DataA(), data2 = new DataB(), data3 = new DataC();
        Data[] data = {data1, data2, data3};
        lr.register(HandlerA.A1, HandlerA.A1::preprocess);
        lr.register(HandlerA.A2, HandlerA.A2::preprocess);
        lr.register(HandlerA.A3, HandlerA.A3::preprocess);
        lr.register(HandlerB.B1, HandlerB.B1::execute);
        lr.register(HandlerB.B2, HandlerB.B2::execute);
        lr.register(HandlerB.B3, HandlerB.B3::execute);
        lr.register(HandlerC.C1, HandlerC.C1::evaluate);
        lr.register(HandlerC.C2, HandlerC.C2::evaluate);
        Phaser phase1 = new Phaser(), phase2 = new Phaser(), phase3 = new Phaser();
        phase1.addHandlerToCurrentPhase(HandlerA.A1);
        phase1.addHandlerToCurrentPhase(HandlerA.A2);
        phase1.addHandlerToCurrentPhase(HandlerA.A3);
        phase2.addHandlerToCurrentPhase(HandlerB.B1);
        phase2.addHandlerToCurrentPhase(HandlerB.B2);
        phase2.addHandlerToCurrentPhase(HandlerB.B3);
        phase3.addHandlerToCurrentPhase(HandlerC.C1);
        phase3.addHandlerToCurrentPhase(HandlerC.C2);
        pr.connectPhases(phase1, phase2);
        pr.connectPhases(phase2, phase3);
        pr.finalPhase(phase3);
        pm.initiateChain(phase1, data, lr, pr);
    }
}
