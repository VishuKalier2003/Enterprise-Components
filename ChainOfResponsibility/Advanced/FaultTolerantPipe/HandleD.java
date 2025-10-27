public class HandleD implements HandlePipe {
    private HandlePipe nextHandle;
    private Bin drainage;

    @Override
    public void handlePipe(HandlePipe pipe) {this.nextHandle = pipe;}

    @Override
    public void drainPipe(Bin pipe) {this.drainage = pipe;}

    @Override
    public HandlePipe handlePipe() {return this.nextHandle;}

    @Override
    public Bin drainPipe() {return this.drainage;}

    @Override
    public boolean execute(InputData input) {
        System.out.println("Handle D executed successfully !!");
        input.setValue(input.random());
        input.show();
        return Math.random() < 0.6;
    }

    @Override
    public InputData flush(InputData input) {
        System.out.println("Handle D drained successfully !!");
        input.setValue(Math.abs(input.getFixedValue() - input.getValue()));
        input.show();
        return input;
    }
}
