
import java.util.List;

public class Chain_Manager {
    private Chain head;

    public void createChain(Packet packet) {
        List<Chain> chain = packet.reorder();
        if(head == null)
            head = chain.get(0);
        Chain temp = head;
        for(int i = 1; i < chain.size(); i++) {
            temp.setNext(chain.get(i));
            temp = temp.getNext();
        }
    }

    public void initiateRequest(IOData data) {
        Chain temp = head;
        while(temp != null) {
            temp.execute(data);
            temp = temp.getNext();
        }
    }
}
