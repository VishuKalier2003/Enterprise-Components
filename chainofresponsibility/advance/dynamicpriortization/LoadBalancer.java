package chainofresponsibility.advance.dynamicpriortization;

import java.util.PriorityQueue;

public class LoadBalancer {

    private static final PriorityQueue<Data> balancer = new PriorityQueue<>((a, b) -> Double.compare(a.getLOAD(), b.getLOAD()));

    public static void smallFanOut(Input input) {
        System.out.println("-------Small Fan Out-------");
        for(int i = 0; i < 2; i++) {
            Metrics metrics = HandlerRegistry.access(balancer.poll().getID()).execute(input);
            MetricsManager.update(metrics);
        }
        balancer.clear();
    }

    public static void push(int index, double load) {
        balancer.offer(Data.createData(index, load));
    }

    public static void largeFanOut(Input input) {
        System.out.println("-------Large Fan Out-------");
        for(int i = 0; i < 4; i++) {
            Metrics metrics = HandlerRegistry.access(balancer.poll().getID()).execute(input);
            MetricsManager.update(metrics);
        }
        balancer.clear();
    }
}
