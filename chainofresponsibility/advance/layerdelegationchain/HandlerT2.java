package chainofresponsibility.advance.layerdelegationchain;

public class HandlerT2 implements TestChain {
    private TestChain next;

    @Override
    public void setNext(TestChain nextNode) {
        this.next = nextNode;
    }

    @Override public TestChain next() {return next;}

    @Override public TestChain get() {return this;}

    @Override
    public boolean executeTest(InputOutput input) {
        double r = Math.random();
        if(r <= 0.9) {
            System.out.println("Handler T2 passed");
            return true;
        }
        System.out.println("Handler T2 failed");
        return false;
    }
}
