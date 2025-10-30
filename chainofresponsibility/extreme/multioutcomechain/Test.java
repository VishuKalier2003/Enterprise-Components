package chainofresponsibility.extreme.multioutcomechain;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Model m1 = new ModelM1("M0"), m2 = new ModelM2("M1"), m3 = new ModelM3("M2"), m4 = new ModelM4("M3");
        Cache cache = new Cache();
        LoadBalancer balancer = new LoadBalancer();
        balancer.initiateLoad(m1.getID());
        balancer.initiateLoad(m2.getID());
        balancer.initiateLoad(m3.getID());
        balancer.initiateLoad(m4.getID());
        Board board = new Board(cache);
        board.insert(0);
        board.insert(1);
        board.insert(2);
        board.insert(3);
        Registry registry = new Registry();
        registry.register(m1.getID(), m1);
        registry.register(m2.getID(), m2);
        registry.register(m3.getID(), m3);
        registry.register(m4.getID(), m4);
        Extractor extractor = new Extractor();
        FeedbackManager fm = new FeedbackManager(board, balancer, registry);
        OutcomeManager om = new OutcomeManager(cache, registry, extractor, balancer, fm);
        Request req = new Request();
        req.setInput("This is a request !!");
        req.setSum(10);
        try (Scanner sc = new Scanner(System.in)) {
        for(int i = 1; i <= 11; i++) {
            System.out.println("ITERATION : "+i);
            if(i % 5 == 0) {
                System.out.println("FEEDBACK MANAGER now takes task of HEALING cracked cells");
                fm.heal();
            }
            else
                om.initiateWork(req, board);
            // board.show();
            balancer.show();
            sc.close();
        }
    }
    }
}
