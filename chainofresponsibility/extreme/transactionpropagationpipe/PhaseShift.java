package chainofresponsibility.extreme.transactionpropagationpipe;

import java.util.function.Function;

public class PhaseShift {
    private static int ID = 1;
    public static Marker createPhasePlug() {
        Marker m = new Marker() {
            private Marker next;
            private String id;

            @Override public void setNext(Marker node) {this.next = node;}
            @Override public Marker getNext() {return this.next;}
            @Override public void setID(String id) {this.id = id;}
            @Override public String getID() {return this.id;}

            @Override public void setCommit(Function<Request, Output> fn) {
                //
            }
            @Override public void setRollback(Function<Request, Output> fn) {//
            }

            @Override public Output commit(Request request) {
                System.out.println("------------------------------");
                System.out.println("Phase Change successful... Shifting to TRANSACTION PHASE "+getID().substring(4)+" after permanently saving to Storage...");
                System.out.println("------------------------------");
                request.setHandlerID(getID());
                return new Output(request, StatusCode.CODE_COMMIT);
            }
            @Override public Output rollback(Request request) {
                System.out.println("Phase Change cancelled!! Committing rollback...");
                request.setHandlerID(getID());
                return new Output(request, StatusCode.CODE_ROLLBACK);
            }

            @Override public StatusCode execute(Request request) {
                return StatusCode.CODE_PASSED;
            }
        };
        m.setID("Plug"+ID);
        ID++;
        return m;
    }
}
