package chainofresponsibility.advance.layerdelegationchain;

public interface PresentationChain extends Chainable<PresentationChain> {
    public boolean executePresent(InputOutput input);
}
