package chainofresponsibility.advance.layerdelegationchain;

public class HandlerP1 implements PresentationChain {
    private PresentationChain next;

    @Override
    public void setNext(PresentationChain nextNode) {
        this.next = nextNode;
    }

    @Override public PresentationChain next() {return next;}

    @Override public PresentationChain get() {return this;}

    @Override
    public boolean executePresent(InputOutput input) {
        double r = Math.random();
        if(r <= 0.9) {
            System.out.println("Handler P1 passed");
            return true;
        }
        System.out.println("Handler P1 failed");
        return false;
    }
}
