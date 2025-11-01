package chainofresponsibility.extreme.transactionpropagationpipe;

import java.util.function.Function;

public interface Chainable {
    public void setNext(Marker node);
    public Marker getNext();
    public void setCommit(Function<Request, Output> fn);
    public void setRollback(Function<Request, Output> fn);
}
