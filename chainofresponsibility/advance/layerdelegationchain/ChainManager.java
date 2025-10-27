package chainofresponsibility.advance.layerdelegationchain;

public class ChainManager {
    private final RouterX router;
    private final Delegator delegator;

    public ChainManager() {
        this.router = new RouterX();
        this.delegator = new Delegator();
    }

    public <T extends Chainable<T>> void addHandle(T handle, String key, Class<T> clazz) {
        T head = router.get(key, clazz);
        if (head == null) {
            router.put(key, handle);
            return;
        }
        T temp = head;
        while (temp.next() != null)
            temp = temp.next();
        temp.setNext(handle);
    }

    public <T extends Chainable<T>> void initiateDelegatorChain(InputOutput ip) {
        int index = 0;
        while (!delegator.isEnd(index)) {
            Chainable info = router.get(delegator.get(index), delegator.getValue(index));
            switch (info) {
                case PresentationChain presentationChain -> initiatePresentationChain(presentationChain, ip);
                case ServiceChain serviceChain -> initiateServiceChain(serviceChain, ip);
                case TestChain testChain -> initiateTestChain(testChain, ip);
                default -> throw new ClassCastException("Error in Class Casting in initiate Delegator Chain !!");
            }
            index++;
        }
    }

    public void initiatePresentationChain(PresentationChain start, InputOutput ip) {
        while (start != null) {
            start.executePresent(ip);
            start = start.next();
        }
    }

    public void initiateServiceChain(ServiceChain start, InputOutput ip) {
        while (start != null) {
            start.executeService(ip);
            start = start.next();
        }
    }

    public void initiateTestChain(TestChain start, InputOutput ip) {
        while (start != null) {
            start.executeTest(ip);
            start = start.next();
        }
    }
}
