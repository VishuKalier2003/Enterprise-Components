public class HandlerE implements Handle {

    public Handle next, retry;

    private final RetryQueue retryQueue;

    public HandlerE(RetryQueue rq) {
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
        if(Math.random() < 0.4) {
            setRetry(new HandlerC());
            retryQueue.push(retry);
            return input+" Handler E failed !!\n";
        }
        return input+" Handler E passed !!\n";
    }

    @Override
    public void setRetry(Handle handle) {
        this.retry = handle;
    }

    @Override
    public Handle getRetry() {return this.retry;}
}
