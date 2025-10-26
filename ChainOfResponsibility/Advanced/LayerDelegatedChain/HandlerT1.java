public class HandlerT1 implements TestChain {
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
            System.out.println("Handler T1 passed");
            return true;
        }
        System.out.println("Handler T1 failed");
        return false;
    }
}
