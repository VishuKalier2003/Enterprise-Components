
public class RetryChainProducer {
    // Delegation of classes
    private Handle head;
    private final RetryQueue retryQueue;

    public RetryChainProducer(RetryQueue rq) {
        this.retryQueue = rq;
    }

    public void addHandle(Handle handle) {
        if(head == null) {
            head = handle;
            return;
        }
        Handle temp = head;
        while(temp.getNext() != null)
            temp = temp.getNext();
        temp.setNext(handle);
    }

    public void setRetryCommand(Handle handle) {
        Handle temp = head;
        while(temp.getNext() != null)
            temp = temp.getNext();
        temp.setRetry(handle);
    }

    public Handle getHead() {return head;}

    public boolean initiateProcess(Handle head, String output, boolean callStack) {
        Handle start = head;
        while(start != null) {
            output = start.handle(output);
            System.out.println(retryQueue.get());
            start = start.getNext();
        }
        while(!retryQueue.isEmpty()) {
            boolean res = initiateProcess(retryQueue.poll(), output, true);
            if(res) {
                retryQueue.flush();
            }
        }
        System.out.println(output);
        return true;
    }
}
