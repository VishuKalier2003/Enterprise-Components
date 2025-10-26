public interface Handle {

    public Handle getNext();

    public void setNext(Handle handle);

    public String handle(String input);

    default void setRetry(Handle handle) {}

    default Handle getRetry() {return null;}
}
