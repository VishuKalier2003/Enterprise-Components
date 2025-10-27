package chainofresponsibility.advance.exceptionescalationchain;

public class HandlerH3 implements Handler {

    private Handler next;

    @Override public void setNext(Handler node) {this.next = node;}
    @Override public Handler getNext() {return this.next;}

    @Override
    public Data execute(Data data) throws ExceptionError {
        while(Math.random() < 0.50) {
            data.setSum(0);
            throw new ExceptionE3("Exception E3 called via Handler H3");
        }
        data.show();
        return data;
    }
}
