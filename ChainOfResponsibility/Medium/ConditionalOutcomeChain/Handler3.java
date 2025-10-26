public class Handler3 implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandle(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public Outcome initiate(Outcome outcome) {
        if(outcome.equals(Outcome.FAIL))
            return Math.random() < 0.3 ? Outcome.FAIL : Outcome.PASS;
        return Math.random() < 0.2 ? Outcome.FAIL : Outcome.PASS;
    }

    @Override
    public Handler next() {return this.nextHandler;}
}
