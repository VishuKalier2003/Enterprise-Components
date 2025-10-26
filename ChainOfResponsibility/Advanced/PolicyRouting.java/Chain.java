public interface Chain {
    public void setNext(Chain node);
    public Chain getNext();
    public IOData execute(IOData input);
    public int getOrder();
    public void setOrder(int order);
    public int getPriority();
}
