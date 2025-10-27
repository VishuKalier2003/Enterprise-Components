package chainofresponsibility.advance.exceptionescalationchain;

public class ZTest {
    public static void main(String[] args) throws ExceptionError {
        Handler h1 = new HandlerH1(), h2 = new HandlerH2(), h3 = new HandlerH3();
        HandleManager hm = new HandleManager();
        hm.addHandler(h1);
        hm.addHandler(h2);
        hm.addHandler(h3);
        Data data = new Data("DATA PACKET");
        hm.initiate(data);
    }
}
