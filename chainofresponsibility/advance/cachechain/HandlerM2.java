package chainofresponsibility.advance.cachechain;

public class HandlerM2 implements Handler {
    private Handler next;

    @Override public void setNext(Handler node) {this.next = node;}
    @Override public Handler getNext() {return this.next;}
    @Override public void execute(BaseOutput output) {
        int r = (int)(Math.round(Math.random() * 10));
        CacheBus.bus(new CacheOutput(output, next, r));
        System.out.println("Handler H2 executed !!");
    }
}
