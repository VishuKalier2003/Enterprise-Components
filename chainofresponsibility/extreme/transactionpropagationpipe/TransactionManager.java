package chainofresponsibility.extreme.transactionpropagationpipe;

public class TransactionManager {
    private final Storage storage;
    private final MarkerRegistry registry;

    public TransactionManager(Storage storage, MarkerRegistry mr) {
        this.storage = storage; this.registry = mr;
    }

    public Marker transaction(Output output) {
        if(output.getStatusCode() == StatusCode.CODE_COMMIT) {
            storage.log(output);
        } else {
            while(!storage.extractLastHandlerID().contains("Plug")) {
                String handlerID = storage.extractLastHandlerID();
                Marker marker = registry.get(handlerID);
                marker.rollback(output.getRequest());
                storage.removeLast();
            }
        }
        return registry.get(storage.extractLastHandlerID());
    }

    public void show() {storage.show();}
}
