package chainofresponsibility.advance.dynamicpriortization;

public class HandlerX2 implements Handler {

    @Override
    public Metrics execute(Input input) {
        int load = (int)(Math.ceil(Math.random() * 5) + 8);
        input.setData(" Handler X2 ");
        System.out.println(input.getData()+" executed !!");
        Metrics metrics = new Metrics(2);
        metrics.setLoad(load);
        metrics.setFired();
        return metrics;
    }
}
