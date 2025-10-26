public class TesterA implements InputHandle {
    private InputHandle next, prev;

    @Override
    public void setNextHandle(InputHandle next) {this.next = next;}

    @Override
    public void setPreviousHandle(InputHandle prev) {this.prev = prev;}

    @Override public InputHandle next() {return this.next;}

    @Override public InputHandle previous() {return this.prev;}

    @Override
    public void rollback(State state) {
        state.money(state.money()-100);
        reduceStateIndex(state);
    }

    @Override
    public boolean proceed(State state) {
        state.money(state.money()+100);
        increaseStateIndex(state);
        return Math.random() >= 0.5;
    }
}
