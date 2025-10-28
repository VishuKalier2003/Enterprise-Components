package chainofresponsibility.advance.reentrantchain;

public class Manager {
    public Handler head;

    public void insert(Handler handler) {
        if(head == null) {
            head = handler;
            head.setRecoil(head);
            head.setEnd();
            return;
        }
        Handler temp = head;
        while(temp.getNext() != null)
            temp = temp.getNext();
        temp.removeEnd();
        temp.setNext(handler);
        temp = temp.getNext();
        temp.setRecoil(head);
        temp.setEnd();
    }

    public void insertRecoil(Handler handler, Handler recoil) {
        Handler temp = head;
        while(temp.getNext() != null)
            temp = temp.getNext();
        temp.removeEnd();
        temp.setNext(handler);
        temp = temp.getNext();
        temp.setRecoil(head);
        temp.setEnd();
    }

    public void initiate(Data data) {
        data.setStatus("QUEUED");
        Handler temp = head;
        while(!data.getStatus().equals(Status.VALIDATED)) {
            temp.execute(data);
            if(temp.getNext() != null) {
                temp = temp.getNext();
            } else {
                temp = temp.getRecoil();
            }
        }
        temp = head;
        while(temp != null) {
            temp.execute(data);
            temp = temp.getNext();
        }
    }
}
