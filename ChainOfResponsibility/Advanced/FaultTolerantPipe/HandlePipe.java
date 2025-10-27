public interface HandlePipe extends DrainPipe {
    public void handlePipe(HandlePipe pipe);
    public HandlePipe handlePipe();
    public boolean execute(InputData input);
}
