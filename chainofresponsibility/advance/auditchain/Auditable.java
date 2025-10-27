package chainofresponsibility.advance.auditchain;

public interface Auditable {
    public AuditData get();

    public void read();
}
