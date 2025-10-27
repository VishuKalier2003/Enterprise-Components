package chainofresponsibility.advance.exceptionescalationchain;

public interface Handler {
    public void setNext(Handler node);
    public Handler getNext();
    public Data execute(Data data) throws ExceptionError;
}
