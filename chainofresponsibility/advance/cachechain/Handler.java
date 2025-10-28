package chainofresponsibility.advance.cachechain;

public interface Handler {
    public void setNext(Handler node);
    public Handler getNext();
    public void execute(BaseOutput input);
}
