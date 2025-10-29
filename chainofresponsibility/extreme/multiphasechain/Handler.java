package chainofresponsibility.extreme.multiphasechain;

public interface Handler {
    public void setNext(Handler next);
    public Handler getNext();
}
