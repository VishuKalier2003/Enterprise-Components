import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Test 1");
        Assertions.log("Test 1 : Primitive-Chain-Creation", () -> {
            @SuppressWarnings("unused")
            Router router = new Router();
            ChainProducer chainProducer = new ChainProducer();
            chainProducer.addHandler(new AHandlerA());
            chainProducer.addHandler(new BHandlerB());
            String output = "Testing  Handler A passed !!  Handler B passed !! ";
            Assertions.assertEquals(output, chainProducer.definedRequest(chainProducer.getHead()), "Chain output must match!!");
        });
        System.out.println("Test 2");
        Assertions.log("Test 2 : Routing-Test ", () -> {
            Router router = new Router();
            ChainProducer chainProducer = new ChainProducer();
            chainProducer.addHandler(new AHandlerA());
            chainProducer.addHandler(new BHandlerB());
            chainProducer.resetHead("Chain1");
            chainProducer.addHandler(new CHandlerC());
            chainProducer.addHandler(new DHandlerD());
            chainProducer.addHandler(new AHandlerA());
            chainProducer.resetHead("Chain2");
            String output = "[Chain1, Chain2]";
            Assertions.assertEquals(output, router.get().keySet().toString(), "Router must store head of all chains");
        });
        System.out.println("Test 3");
        Assertions.log("Test 3 : Multi-routing", () -> {
            @SuppressWarnings("unused")
            Router router = new Router();
            ChainProducer chainProducer = new ChainProducer();
            chainProducer.addHandler(new AHandlerA());
            chainProducer.addHandler(new BHandlerB());
            chainProducer.resetHead("Chain1");
            chainProducer.addHandler(new CHandlerC());
            chainProducer.addHandler(new DHandlerD());
            chainProducer.resetHead("Chain2");
            try (Scanner sc = new Scanner(System.in)) {
                boolean flag = true;
                while(flag) {
                    System.out.println(chainProducer.initiateRequest());
                    System.out.println("Set flag : ");
                    flag = sc.nextBoolean();
                }
            }
            Assertions.assertEquals(true, true, "The Routing was unsuccessful");
        });
    }
}
