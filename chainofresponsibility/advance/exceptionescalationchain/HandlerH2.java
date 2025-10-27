package chainofresponsibility.advance.exceptionescalationchain;

public class HandlerH2 implements Handler {

    private Handler next;

    @Override public void setNext(Handler node) {this.next = node;}
    @Override public Handler getNext() {return this.next;}

    @Override
    public Data execute(Data data) throws ExceptionError {
        while(Math.random() < 0.50) {
            data.setSum(11);
            throw new ExceptionE2("Exception E2 called via Handler H2");
        }
        while(Math.random() < 0.50) {
            data.setSum(-100);
            throw new ExceptionE1("Exception E1 called via Handler H2");
        }
        data.show();
        return data;
    }
}
