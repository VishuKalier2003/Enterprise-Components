public interface InputHandle {
    public void setNextHandle(InputHandle next);
    public void setPreviousHandle(InputHandle prev);

    public InputHandle next();
    public InputHandle previous();

    public void rollback(State state);
    public boolean proceed(State state);
    default void reduceStateIndex(State state) {state.reduceIndex();}
    default void increaseStateIndex(State state) {state.increaseIndex();}
}
