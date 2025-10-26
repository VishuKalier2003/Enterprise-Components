public class TransactionManager {
    private InputHandle head;

    public void addInputHandle(InputHandle nextHandle) {
        if(head == null) {head = nextHandle; return;}
        InputHandle temp = head;
        while(temp.next() != null)
            temp = temp.next();
        temp.setNextHandle(nextHandle);
        nextHandle.setPreviousHandle(temp);
    }

    public void initiate(State state) {
        InputHandle temp = head;
        Boolean transaction = null;
        while(temp != null) {
            state.show();
            if(!Boolean.FALSE.equals(transaction))
                transaction = temp.proceed(state);
            if(Boolean.TRUE.equals(transaction))
                temp = temp.next();
            else {
                temp.rollback(state);
                temp = temp.previous();
            }
        }
    }
}
