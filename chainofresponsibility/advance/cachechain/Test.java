package chainofresponsibility.advance.cachechain;

public class Test {
    public static void main(String[] args) {
        // Step 1: Create cache and start cache consumer thread
        Cache cache = new Cache();
        CacheBus bus = new CacheBus();
        CacheManager manager = new CacheManager(cache, bus);
        Thread cacheThread = new Thread(manager);
        cacheThread.setDaemon(true);  // background thread
        cacheThread.start();

        // Step 2: Build handler chain
        Handler h1 = new HandlerM1();
        Handler h2 = new HandlerM1(); // can be a different handler too
        Manager corManager = new Manager();
        corManager.addNode(h1);
        corManager.addNode(h2);

        // Step 3: Create request/output object
        BaseOutput output = new BaseOutput();
        output.setReqID("REQ_001");

        // Step 4: Trigger the chain
        corManager.initiate(output);

        // Step 5: Simulate additional runs
        for (int i = 0; i < 3; i++) {
            BaseOutput o = new BaseOutput();
            o.setReqID("REQ_" + (i + 2));
            corManager.initiate(o);
        }

        // Let background cache manager process events
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        System.out.println("=== Test Complete ===");
    }
}
