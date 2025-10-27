package chainofresponsibility.advance.auditchain;

public class BaseAudit implements Auditable {
    private final AuditData audit;

    public BaseAudit(String log, String handler) {
        this.audit = new AuditData();
        this.audit.setLog(log);
        this.audit.setHandleID(log);
    }

    @Override public void read() {
        System.out.println("------Audit------");
        System.out.println("Log : "+audit.getLog());
        System.out.println("Handler : "+audit.getHandleID());
        System.out.println("Status : "+audit.getStatus());
    }

    @Override
    public AuditData get() {return audit;}
}
