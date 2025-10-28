package chainofresponsibility.advance.cachechain;

public class Manager {
    private Handler head;

    public void addNode(Handler node) {
        if(head == null) {
            head = node;
            return;
        }
        Handler temp = head;
        while(temp.getNext() != null)
            temp = temp.getNext();
        temp.setNext(node);
    }

    public void initiate(BaseOutput input) {
        Handler t = head;
        while(t != null) {
            t.execute(input);
            t = t.getNext();
        }
    }
}
