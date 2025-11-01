package chainofresponsibility.extreme.transactionpropagationpipe;

import java.util.function.Function;

public enum CompletionFunctionRegistry implements Event {
    COMPLETION {
        @Override public Function<Request, Output> forward() {
            return req -> {
                System.out.println("COMMIT C1: The transaction is COMPLETED saving into Database !!");
                req.setHandlerID("complete-1");
                return new Output(req, StatusCode.CODE_COMMIT);
            };
        }
        @Override public Function<Request, Output> backward() {
            return req -> {
                System.out.println("ROLLBACK C1: The post processing failed retrying.... Logging from Storage....");
                req.setHandlerID("complete-1");
                return new Output(req, StatusCode.CODE_ROLLBACK);
            };
        }
        @Override public Function<Request, StatusCode> execute() {
            return req -> {
                    if(Math.random() < 0.5) {
                        System.out.println("EXECUTED C1: The post processing has started...");
                        return StatusCode.CODE_FAILED;
                    }
                System.out.println("EXECUTED C1: The post processing has started...");
                return StatusCode.CODE_PASSED;
            };
        }
    }
}
