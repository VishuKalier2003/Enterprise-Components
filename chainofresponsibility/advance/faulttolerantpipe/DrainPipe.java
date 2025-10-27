package chainofresponsibility.advance.faulttolerantpipe;

public interface DrainPipe {
    public void drainPipe(Bin pipe);
    public Bin drainPipe();
    public InputData flush(InputData input);
}
