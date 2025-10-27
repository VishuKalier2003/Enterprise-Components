package chainofresponsibility.advance.auditchain;

public class Factory {
    public static BaseAudit createBase(String s1, String s2) {return new BaseAudit(s1, s2);}

    public static UpdateAudit createUpdate(String s1, String s2) {return new UpdateAudit(createBase(s1, s2));}

    public static HeavyAudit createHeavy(String s1, String s2) {return new HeavyAudit(createUpdate(s1, s2));}
}
