package chainofresponsibility.extreme.transactionpropagationpipe;

public class ChainManager {
    private Marker head;
    private final CommandOrchestrator orchestrator;
    private final MarkerRegistry registry;

    public ChainManager(CommandOrchestrator co, MarkerRegistry mr) {
        this.orchestrator = co; this.registry = mr;
    }

    public void addHandler(Marker marker) {
        if(head == null) {
            Marker phase = PhaseShift.createPhasePlug();
            registry.put(phase.getID(), phase);
            head = phase;
        }
        Marker temp = head;
        while(temp.getNext() != null)
            temp = temp.getNext();
        temp.setNext(marker);
    }

    public void addPhaseSignal() {
        Marker temp = head;
        while(temp.getNext() != null)
            temp = temp.getNext();
        Marker phase = PhaseShift.createPhasePlug();
        registry.put(phase.getID(), phase);
        temp.setNext(phase);
    }

    public StatusCode initiateTransaction(Request request, TransactionManager manager) {
        Marker temp = head;
        while(temp != null) {
            orchestrator.setCommand(temp);
            StatusCode code = orchestrator.getCommand().execute(request);
            Output output;
            if(code == StatusCode.CODE_PASSED)
                output = orchestrator.getCommand().commit(request);
            else
                output = orchestrator.getCommand().rollback(request);
            orchestrator.setTransactionEventCommand(output);
            temp = manager.transaction(orchestrator.getTransactionEventCommand());
            // manager.show();
            // System.out.println("tempID : "+temp.getID());
            temp = temp.getNext();
            // if(temp != null)
            //     System.out.println("tempID : "+temp.getID());
        }
        return StatusCode.CODE_PASSED;
    }
}
