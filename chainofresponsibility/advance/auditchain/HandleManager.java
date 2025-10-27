package chainofresponsibility.advance.auditchain;

public class HandleManager {
    private Handler head;

    public void attach(Handler node) {
        if(head == null) {
            head = node;
            return;
        }
        Handler temp = head;
        while(temp.getHandler() != null)
            temp = temp.getHandler();
        temp.setHandler(node);
    }

    public void initiate() {
        Handler temp = head;
        while(temp != null) {
            temp.execute();
            temp = temp.getHandler();
        }
    }
}
