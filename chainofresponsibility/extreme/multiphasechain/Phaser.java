package chainofresponsibility.extreme.multiphasechain;

public class Phaser {
    public Linkable head;

    public void addHandlerToCurrentPhase(Linkable node) {
        if(head == null) {
            head = node;
        } else {
            Linkable current = head;
            while(current.getNext() != null) {
                current = (Linkable) current.getNext();
            }
            current.setNext(node);
        }
    }

    public void initiate(Data data, LambdaRegistry lr) {
        Linkable current = head;
        while(current != null) {
            data = lr.execute(current, data);
            current = (Linkable) current.getNext();
        }
    }
}
