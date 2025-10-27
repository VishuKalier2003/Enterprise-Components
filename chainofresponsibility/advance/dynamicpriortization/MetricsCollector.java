package chainofresponsibility.advance.dynamicpriortization;
public class MetricsCollector {

    public static double extractBalanceFactor(Metrics metrics) {
        return metrics.getLoadRatio();
    }

    public static int extractHandlerID(Metrics metrics) {
        return metrics.getHandlerID();
    }
}
