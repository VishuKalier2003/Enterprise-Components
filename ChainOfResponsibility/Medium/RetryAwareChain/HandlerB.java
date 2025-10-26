public class HandlerB implements Handle {

    public Handle next, retry;

    private final RetryQueue retryQueue;

    public HandlerB(RetryQueue rq) {
        this.retryQueue = rq;
    }

    @Override
    public void setNext(Handle handle) {
        this.next = handle;
    }

    @Override
    public Handle getNext() {return next;}

    @Override
    public String handle(String input) {
        if(Math.random() < 0.5) {
            setRetry(new HandlerA());
            retryQueue.push(retry);
            return input+" Handler B failed !!\n";
        }
        return input+" Handler B passed !!\n";
    }

    @Override
    public void setRetry(Handle handle) {
        this.retry = handle;
    }

    @Override
    public Handle getRetry() {return this.retry;}
}
