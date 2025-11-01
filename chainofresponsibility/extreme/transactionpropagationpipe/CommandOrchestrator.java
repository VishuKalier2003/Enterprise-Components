package chainofresponsibility.extreme.transactionpropagationpipe;

public class CommandOrchestrator {
    private Command command;
    private Output outputCommand;

    public void setCommand(Command command) {this.command = command;}
    public void setTransactionEventCommand(Output output) {this.outputCommand = output;}
    public Command getCommand() {return this.command;}
    public Output getTransactionEventCommand() {return this.outputCommand;}
}
