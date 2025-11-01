package chainofresponsibility.extreme.transactionpropagationpipe;

public class Test {
    public static void main(String[] args) {
        final Storage storage = new Storage();
        final CommandOrchestrator co = new CommandOrchestrator();
        final MarkerRegistry mr = new MarkerRegistry();
        final ChainManager cm = new ChainManager(co, mr);
        final TransactionManager tm = new TransactionManager(storage, mr);
        final Handler h1 = new Handler("register-1", RegistrationFunctionRegistry.REGISTER.execute()),
        h2 = new Handler("auth-1", AuthenticationFunctionRegistry.AUTHENTICATE.execute()),
        h3 = new Handler("auth-2", AuthenticationFunctionRegistry.AUTHORIZE.execute()),
        h4 = new Handler("pay-1", PaymentFunctionRegistry.INITIATE.execute()),
        h5 = new Handler("pay-2", PaymentFunctionRegistry.TRANSACTION.execute()),
        h6 = new Handler("pay-3", PaymentFunctionRegistry.TRANSACTION_FEE.execute()),
        h7 = new Handler("complete-1", CompletionFunctionRegistry.COMPLETION.execute());
        mr.put(h1.getID(), h1);
        mr.put(h2.getID(), h2);
        mr.put(h3.getID(), h3);
        mr.put(h4.getID(), h4);
        mr.put(h5.getID(), h5);
        mr.put(h6.getID(), h6);
        mr.put(h7.getID(), h7);
        h1.setCommit(RegistrationFunctionRegistry.REGISTER.forward());
        h1.setRollback(RegistrationFunctionRegistry.REGISTER.backward());
        h2.setCommit(AuthenticationFunctionRegistry.AUTHENTICATE.forward());
        h2.setRollback(AuthenticationFunctionRegistry.AUTHENTICATE.backward());
        h3.setCommit(AuthenticationFunctionRegistry.AUTHORIZE.forward());
        h3.setRollback(AuthenticationFunctionRegistry.AUTHORIZE.backward());
        h4.setCommit(PaymentFunctionRegistry.INITIATE.forward());
        h4.setRollback(PaymentFunctionRegistry.INITIATE.backward());
        h5.setCommit(PaymentFunctionRegistry.TRANSACTION.forward());
        h5.setRollback(PaymentFunctionRegistry.TRANSACTION.backward());
        h6.setCommit(PaymentFunctionRegistry.TRANSACTION_FEE.forward());
        h6.setRollback(PaymentFunctionRegistry.TRANSACTION_FEE.backward());
        h7.setCommit(CompletionFunctionRegistry.COMPLETION.forward());
        h7.setRollback(CompletionFunctionRegistry.COMPLETION.backward());
        cm.addHandler(h1);
        cm.addPhaseSignal();
        cm.addHandler(h2);
        cm.addHandler(h3);
        cm.addPhaseSignal();
        cm.addHandler(h4);
        cm.addHandler(h5);
        cm.addHandler(h6);
        cm.addPhaseSignal();
        cm.addHandler(h7);
        Request request = new Request();
        request.getData().put("name", "VISHU");
        request.setSum(100);
        cm.initiateTransaction(request, tm);
    }
}
