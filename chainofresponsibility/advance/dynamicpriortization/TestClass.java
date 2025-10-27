package chainofresponsibility.advance.dynamicpriortization;
public class TestClass {
    public static void main(String[] args) {
        Handler h1 = new HandlerX1(), h2 = new HandlerX2(), h3 = new HandlerX3();
        Handler h4 = new HandlerX4(), h5 = new HandlerX5();
        HandlerRegistry.register(1, h1);
        HandlerRegistry.register(2, h2);
        HandlerRegistry.register(3, h3);
        HandlerRegistry.register(4, h4);
        HandlerRegistry.register(5, h5);
        MetricsManager.init();
        Input input = new Input();
        for(int i = 0; i < 5; i++) {
            System.out.println("--------ITERATION 1-------");
            MetricsManager.get();
            MetricsManager.pushToBalancer();
            int x = (int)(Math.round(Math.random()));
            if(x == 0)
                LoadBalancer.smallFanOut(input);
            else
                LoadBalancer.largeFanOut(input);
        }
    }
}
