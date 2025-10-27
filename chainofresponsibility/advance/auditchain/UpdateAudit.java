package chainofresponsibility.advance.auditchain;

public class UpdateAudit implements Auditable {
    private final BaseAudit baseAudit;

    public UpdateAudit(BaseAudit audit) {this.baseAudit = audit;}

    @Override public void read() {
        System.out.println("------Update Status------");
        baseAudit.get().setStatus(400);
        System.out.println("Message : "+baseAudit.get().getMessage());
    }

    @Override
    public AuditData get() {return baseAudit.get();}
}
