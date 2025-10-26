public class HandlerX5 implements Handler {

    @Override
    public Metrics execute(Input input) {
        int load = (int)(Math.ceil(Math.random() * 5) + 5);
        input.setData(" Handler X5 ");
        System.out.println(input.getData()+" executed !!");
        Metrics metrics = new Metrics(5);
        metrics.setLoad(load);
        metrics.setFired();
        return metrics;
    }
}
