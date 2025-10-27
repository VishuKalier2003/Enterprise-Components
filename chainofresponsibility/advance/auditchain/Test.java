package chainofresponsibility.advance.auditchain;

public class Test {
    public static void main(String[] args) {
        Handler q1 = new HandlerQ1(), q2 = new HandlerQ2(), q3 = new HandlerQ3();
        q1.assignAudit(Factory.createBase("Hello", "Handler Q1"));
        q2.assignAudit(Factory.createUpdate("Testing", "Handler Q2"));
        q3.assignAudit(Factory.createHeavy("Provisioned Testing", "Handler Q3"));
        HandleManager hm = new HandleManager();
        hm.attach(q1);
        hm.attach(q2);
        hm.attach(q3);
        hm.initiate();
        AuditLogger.drainLogger();
    }
}
