public class HandlerX1 implements Handler {

    @Override
    public Metrics execute(Input input) {
        int load = (int)(Math.ceil(Math.random() * 10) + 1);
        input.setData(" Handler X1 ");
        System.out.println(input.getData()+" executed !!");
        Metrics metrics = new Metrics(1);
        metrics.setLoad(load);
        metrics.setFired();
        return metrics;
    }
}
