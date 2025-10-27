package chainofresponsibility.advance.auditchain;

public class HeavyAudit implements Auditable {
    private final UpdateAudit uAudit;

    public HeavyAudit(UpdateAudit audit) {this.uAudit = audit;}

    @Override public void read() {
        System.out.println("------Update Status------");
        uAudit.get().setStatus(200);
        uAudit.get().setMessage("Heavy Audit Called");
        System.out.println("Message : "+uAudit.get().getMessage());
    }

    @Override
    public AuditData get() {return uAudit.get();}
}
