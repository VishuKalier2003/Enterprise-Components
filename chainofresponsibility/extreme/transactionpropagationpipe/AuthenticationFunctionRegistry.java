package chainofresponsibility.extreme.transactionpropagationpipe;

import java.util.function.Function;

public enum AuthenticationFunctionRegistry implements Event {
    AUTHENTICATE {
        @Override public Function<Request, Output> forward() {
            return req -> {
                System.out.println("COMMIT A1: The user is checked for Authentication!! Logging in Storage!!");
                req.setHandlerID("auth-1");
                return new Output(req, StatusCode.CODE_COMMIT);
            };
        }
        @Override public Function<Request, Output> backward() {
            return req -> {
                System.out.println("ROLLBACK A1: The user failed the Authentication!! Logging from Storage!!");
                req.setHandlerID("auth-1");
                return new Output(req, StatusCode.CODE_ROLLBACK);
            };
        }
        @Override public Function<Request, StatusCode> execute() {
            return req -> {
                String name = req.getData().get("name");
                int len = name.length();
                for(int i = 0; i < len; i++)
                    if(Character.isLowerCase(name.charAt(i))) {
                        System.out.println("EXECUTED A1: The user name has lowercase letters, authentication fails here!!");
                        return StatusCode.CODE_FAILED;
                    }
                System.out.println("EXECUTED A1: The user name is all Upper case letters, authenticating further...");
                return StatusCode.CODE_PASSED;
            };
        }
    },
    AUTHORIZE {
        @Override public Function<Request, Output> forward() {
            return req -> {
                System.out.println("COMMIT A2: The user is given Authorization!! Logging in Storage!!");
                req.setHandlerID("auth-2");
                return new Output(req, StatusCode.CODE_COMMIT);
            };
        }
        @Override public Function<Request, Output> backward() {
            return req -> {
                System.out.println("ROLLBACK A2: The user Authorization is revoked!! Logging from Storage!!");
                req.setHandlerID("auth-2");
                return new Output(req, StatusCode.CODE_ROLLBACK);
            };
        }
        @Override public Function<Request, StatusCode> execute() {
            return req -> {
                if(Math.random() < 0.5) {
                    System.out.println("EXECUTED A2: The Authorization cannot be permitted yet, fails here!!");
                    return StatusCode.CODE_FAILED;
                }
                System.out.println("EXECUTED A2: The user is now Authorized, Authorization stage is completed...");
                return StatusCode.CODE_PASSED;
            };
        }
    };
}
