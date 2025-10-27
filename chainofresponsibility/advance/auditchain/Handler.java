package chainofresponsibility.advance.auditchain;

public interface Handler {
    public void setHandler(Handler handler);
    public void assignAudit(Auditable auditable);

    public Handler getHandler();
    public Auditable getAudit();

    public boolean execute();
}
