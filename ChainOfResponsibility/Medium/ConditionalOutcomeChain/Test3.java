public class Test3 {
    public static void main(String[] args) {
        Handler h1 = new Handler1(), h2 = new Handler2(), h3 = new Handler3();
        ChainManager cm = new ChainManager();
        cm.addHandler(h1);
        cm.addHandler(h2);
        cm.addHandler(h3);
        cm.initiateRequest();
    }
}
