package chainofresponsibility.advance.dynamicpriortization;

public interface Handler {
    public Metrics execute(Input input);
}
