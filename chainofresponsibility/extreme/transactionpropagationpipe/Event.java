package chainofresponsibility.extreme.transactionpropagationpipe;

import java.util.function.Function;

public interface Event {
    public Function<Request, Output> forward();
    public Function<Request, Output> backward();
    public Function<Request, StatusCode> execute();
}
