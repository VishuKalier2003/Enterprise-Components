public class ChainManager {
    private Handler head;

    public void addHandler(Handler handler) {
        if(head == null) {head = handler; return;}
        Handler temp = head;
        while(temp.next() != null)
            temp = temp.next();
        temp.setNextHandle(handler);
    }

    public void initiateRequest() {
        Handler temp = head;
        Outcome input = Outcome.PASS;
        int idx = 1;
        while(temp != null) {
            input = temp.initiate(input);
            if(Outcome.PASS.equals(input)) {
                System.out.println("Outcome passed for handler "+idx);
                temp = temp.next();
                idx++;
            }
            else {
                System.out.println("Outcome failed for handler "+idx);
            }
        }
    }
}
