package chainofresponsibility.advance.exceptionescalationchain;

public class HandlerH1 implements Handler {
    private Handler next;

    @Override public void setNext(Handler node) {this.next = node;}
    @Override public Handler getNext() {return this.next;}

    @Override
    public Data execute(Data data) throws ExceptionError {
        while(Math.random() < 0.25) {
            data.setSum(-100);
            throw new ExceptionE1("Exception E1 called via Handler H1");
        }
        data.show();
        return data;
    }
}
