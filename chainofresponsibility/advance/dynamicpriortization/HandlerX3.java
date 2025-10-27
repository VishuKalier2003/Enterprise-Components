package chainofresponsibility.advance.dynamicpriortization;

public class HandlerX3 implements Handler {

    @Override
    public Metrics execute(Input input) {
        int load = (int)(Math.ceil(Math.random() * 4) + 4);
        input.setData(" Handler X3 ");
        System.out.println(input.getData()+" executed !!");
        Metrics metrics = new Metrics(3);
        metrics.setLoad(load);
        metrics.setFired();
        return metrics;
    }
}
