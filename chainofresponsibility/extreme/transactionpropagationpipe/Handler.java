package chainofresponsibility.extreme.transactionpropagationpipe;

import java.util.function.Function;

public class Handler implements Marker {
    private Function<Request, Output> commit, rollback;
    private final Function<Request, StatusCode> execute;
    private Marker next;
    private String id;

    public Handler(String ID, Function<Request, StatusCode> fn) {
        this.id = ID;
        this.execute = fn;
    }

    @Override public void setNext(Marker node) {this.next = node;}
    @Override public Marker getNext() {return this.next;}
    @Override public void setID(String id) {this.id = id;}
    @Override public String getID() {return this.id;}
    @Override public void setCommit(Function<Request, Output> fn) {this.commit = fn;}
    @Override public void setRollback(Function<Request, Output> fn) {this.rollback = fn;}

    @Override public Output commit(Request request) {return commit.apply(request);}
    @Override public Output rollback(Request request) {return rollback.apply(request);}

    @Override public StatusCode execute(Request request) {
        return execute.apply(request);
    }
}
