package chainofresponsibility.advance.faulttolerantpipe;

// When each handlePipe (here Handler) always has a DrainPipe, extend it into another interface and then use it
public interface HandlePipe extends DrainPipe {
    public void handlePipe(HandlePipe pipe);
    public HandlePipe handlePipe();
    public boolean execute(InputData input);
}
