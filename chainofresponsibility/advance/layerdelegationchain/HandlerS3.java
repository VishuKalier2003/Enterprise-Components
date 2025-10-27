package chainofresponsibility.advance.layerdelegationchain;

public class HandlerS3 implements ServiceChain {
    private ServiceChain next;

    @Override
    public void setNext(ServiceChain nextNode) {
        this.next = nextNode;
    }

    @Override public ServiceChain next() {return next;}

    @Override public ServiceChain get() {return this;}

    @Override
    public boolean executeService(InputOutput input) {
        double r = Math.random();
        if(r <= 0.9) {
            System.out.println("Handler S3 passed");
            return true;
        }
        System.out.println("Handler S3 failed");
        return false;
    }
}
