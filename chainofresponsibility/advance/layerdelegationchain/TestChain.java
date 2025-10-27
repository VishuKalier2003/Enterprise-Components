package chainofresponsibility.advance.layerdelegationchain;

public interface TestChain extends Chainable<TestChain> {
    public boolean executeTest(InputOutput input);
}
