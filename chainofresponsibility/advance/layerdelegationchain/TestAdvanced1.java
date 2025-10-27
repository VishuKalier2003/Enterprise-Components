package chainofresponsibility.advance.layerdelegationchain;

public class TestAdvanced1 {
    public static void main(String[] args) {
        ChainManager manager = new ChainManager();
        PresentationChain p1 = new HandlerP1(), p2 = new HandlerP2();
        ServiceChain s1 = new HandlerS1(), s2 = new HandlerS2(), s3 = new HandlerS3();
        TestChain t1 = new HandlerT1(), t2 = new HandlerT2();
        manager.addHandle(p1, "PRESENTATION", PresentationChain.class);
        manager.addHandle(p2, "PRESENTATION", PresentationChain.class);
        manager.addHandle(s1, "SERVICE", ServiceChain.class);
        manager.addHandle(s2, "SERVICE", ServiceChain.class);
        manager.addHandle(s3, "SERVICE", ServiceChain.class);
        manager.addHandle(t1, "TEST", TestChain.class);
        manager.addHandle(t2, "TEST", TestChain.class);
        manager.initiateDelegatorChain(new InputOutput());
    }
}
