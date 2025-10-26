public interface Chainable<T extends Chainable<T>> {
    public void setNext(T nextNode);
    public T next();
    public T get();
}
