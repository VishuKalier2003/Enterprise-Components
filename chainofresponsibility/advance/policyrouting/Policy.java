package chainofresponsibility.advance.policyrouting;
public interface Policy {
    public Packet arrange(Packet input);
}
