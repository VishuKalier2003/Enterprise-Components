package chainofresponsibility.extreme.transactionpropagationpipe;

import java.util.function.Function;

public enum RegistrationFunctionRegistry implements Event {
    REGISTER {
        @Override public Function<Request, Output> forward() {
            return request -> {
                System.out.println("COMMIT R1: The User is stored into database !!");
                request.setHandlerID("register-1");
                return new Output(request, StatusCode.CODE_COMMIT);};
        }
        @Override public Function<Request, Output> backward() {
            return request -> {
                System.out.println("ROLLBACK R1: The User is rolled from database !!");
                request.setHandlerID("register-1");
                return new Output(request, StatusCode.CODE_ROLLBACK);
            };
        }
        @Override public Function<Request, StatusCode> execute() {
            return request -> {
                System.out.println("EXECUTION R1: The User is registered !!");
                return StatusCode.CODE_PASSED;
            };
        }
    };
}
