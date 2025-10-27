package chainofresponsibility.advance.auditchain;

public class HandlerQ3 implements Handler{
    private Handler handler;
    private Auditable audit;

    @Override public void assignAudit(Auditable auditable) {this.audit = auditable;}
    @Override public void setHandler(Handler handler) {this.handler = handler;}

    @Override public Handler getHandler() {return this.handler;}
    @Override public Auditable getAudit() {return this.audit;}

    @Override public boolean execute() {
        AuditLogger.fuseIntoQueue(audit);
        if(Math.random() < 0.65) {
            System.out.println("Handler Q3 executed");
            return true;
        }
        else {
            System.out.println("Handler Q3 failed !!");
            return false;
        }
    }
}
