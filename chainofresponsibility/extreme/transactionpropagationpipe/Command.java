package chainofresponsibility.extreme.transactionpropagationpipe;

public interface Command {
    public String getID();
    public void setID(String id);
    public StatusCode execute(Request request);
    public Output commit(Request request);
    public Output rollback(Request request);
}
