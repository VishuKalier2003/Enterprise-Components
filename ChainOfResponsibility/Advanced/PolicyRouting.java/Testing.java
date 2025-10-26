
import java.util.ArrayList;
import java.util.List;

public class Testing {
    public static void main(String[] args) {
        PolicyRegistry registry = new PolicyRegistry();
        Chain_Manager cm = new Chain_Manager();
        Chain h1 = new HandlerR1(2, 100), h2 = new HandlerR2(4, 50);
        Chain h3 = new HandlerR3(1, 75), h4 = new HandlerR4(3, 25);
        List<Chain> lst = new ArrayList<>();
        lst.add(h1);
        lst.add(h2);
        lst.add(h3);
        lst.add(h4);
        String array[] = new String[]{"ASC", "DES", "RAN"};
        int index = (int)(Math.floor(Math.random() * 3));
        cm.createChain(registry.accessRegistry(array[index]).arrange(Factory.createFullPacket(lst)));
        cm.initiateRequest(Factory.createInputPacket());
    }
}
