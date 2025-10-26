public class ChainProducer {
    // Delegation of classes
    private HandleX head;
    private final Router router;

    public ChainProducer() {this.head = null; this.router = new Router();}

    public void resetHead(String name) {
        router.addChain(name, head);
        head = null;
    }

    public HandleX getHead() {return head;}

    public void addHandler(HandleX handle) {
        if(head == null) {
            head = handle;
            return;
        }
        HandleX temp = head;
        while(temp.getNext() != null)
            temp = temp.getNext();
        temp.setNext(handle);
    }

    public String initiateRequest() {
        HandleX start = router.getChain();
        String output = "Testing ";
        while(start != null) {
            output = start.handle(output);
            start = start.getNext();
        }
        return output;
    }

    public String definedRequest(HandleX start) {
        String output = "Testing ";
        while(start != null) {
            output = start.handle(output);
            start = start.getNext();
        }
        return output;
    }
}
