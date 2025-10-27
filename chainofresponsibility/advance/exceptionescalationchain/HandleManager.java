package chainofresponsibility.advance.exceptionescalationchain;

public class HandleManager {
    private Handler head;

    public void addHandler(Handler handler) {
        if(head == null) {
            head = handler;
            return;
        }
        Handler temp = head;
        while(temp.getNext() != null)
            temp = temp.getNext();
        temp.setNext(handler);
    }

    public void initiate(Data data) throws ExceptionError {
        Handler temp = head;
        while(temp != null) {
            try {
                temp.execute(data);
            } catch(ExceptionError e) {
                EnumOfException.resolveError(data, e);
            }
            temp = temp.getNext();
        }
    }
}
