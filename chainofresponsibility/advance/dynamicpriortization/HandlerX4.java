package chainofresponsibility.advance.dynamicpriortization;

public class HandlerX4 implements Handler {

    @Override
    public Metrics execute(Input input) {
        int load = (int)(Math.ceil(Math.random() * 10) + 4);
        input.setData(" Handler X4 ");
        System.out.println(input.getData()+" executed !!");
        Metrics metrics = new Metrics(4);
        metrics.setLoad(load);
        metrics.setFired();
        return metrics;
    }
}
