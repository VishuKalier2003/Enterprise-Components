package chainofresponsibility.extreme.transactionpropagationpipe;

import java.util.function.Function;

public enum PaymentFunctionRegistry implements Event {
    INITIATE {
        @Override public Function<Request, Output> forward() {
            return req -> {
                System.out.println("COMMIT P1: The payment is initiated, kindly wait... Logging in Storage!!");
                req.setHandlerID("pay-1");
                return new Output(req, StatusCode.CODE_COMMIT);
            };
        }
        @Override public Function<Request, Output> backward() {
            return req -> {
                System.out.println("ROLLBACK P1: The payment initiation failed... Logging from Storage!!");
                req.setHandlerID("pay-1");
                return new Output(req, StatusCode.CODE_ROLLBACK);
            };
        }
        @Override public Function<Request, StatusCode> execute() {
            return req -> {
                if(req.getSum() < 10) {
                        System.out.println("EXECUTED P1: The account has very little balance, payment initiation fails here!!");
                        return StatusCode.CODE_FAILED;
                    }
                System.out.println("EXECUTED P1: The account has sufficient balance, performing transaction now...");
                return StatusCode.CODE_PASSED;
            };
        }
    }, TRANSACTION {
        @Override public Function<Request, Output> forward() {
            return req -> {
                System.out.println("COMMIT P2: The payment evaluation is now completed!! Logging in Storage!!");
                req.setHandlerID("pay-2");
                return new Output(req, StatusCode.CODE_COMMIT);
            };
        }
        @Override public Function<Request, Output> backward() {
            return req -> {
                System.out.println("ROLLBACK P2: The payment evaluation failed!! Logging from Storage!!");
                req.setHandlerID("pay-2");
                double amt = req.getAmount();
                amt -= 2 * req.getSum();
                req.setAmount(amt);
                return new Output(req, StatusCode.CODE_ROLLBACK);
            };
        }
        @Override public Function<Request, StatusCode> execute() {
            return req -> {
                double amt = req.getAmount();
                amt += 2* req.getSum();
                req.setAmount(amt);
                if(Math.random() < 0.25) {
                        System.out.println("EXECUTED P2: The evaluation fails due to glitch, transaction fails here, performing rollback!!");
                        return StatusCode.CODE_FAILED;
                    }
                System.out.println("EXECUTED P2: The evaluation is completed, moving further...");
                return StatusCode.CODE_PASSED;
            };
        }
    }, TRANSACTION_FEE {
        @Override public Function<Request, Output> forward() {
            return req -> {
                System.out.println("COMMIT P3: The transaction fee is being added to the transaction!! Logging in Storage!!");
                req.setHandlerID("pay-3");
                return new Output(req, StatusCode.CODE_COMMIT);
            };
        }
        @Override public Function<Request, Output> backward() {
            return req -> {
                System.out.println("ROLLBACK P3: The transaction fee cannot be added into the transaction!! Logging from Storage!!");
                req.setHandlerID("pay-4");
                double amt = req.getAmount();
                amt -= 1.44;
                req.setAmount(amt);
                return new Output(req, StatusCode.CODE_ROLLBACK);
            };
        }
        @Override public Function<Request, StatusCode> execute() {
            return req -> {
                double amt = req.getAmount();
                amt += 1.44;
                req.setAmount(amt);
                if(Math.random() < 0.2) {
                        System.out.println("EXECUTED: The transaction fee cannot be applied due to server load, fee evaluation fails here!!");
                        return StatusCode.CODE_FAILED;
                    }
                System.out.println("EXECUTED: The transaction fee is successfully applied, the transaction is being carried out....");
                return StatusCode.CODE_PASSED;
            };
        }
    };
}
