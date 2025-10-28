package chainofresponsibility.advance.reentrantchain;

public abstract class Handler {
    protected Handler next, recoil;
    protected boolean end;

    public void setEnd() {this.end = true;}
    public void removeEnd() {this.end = false;}
    public boolean isEnd() {return this.end;}

    public abstract void setNext(Handler next);
    public abstract void setRecoil(Handler recoil);
    public abstract Handler getNext();
    public abstract Handler getRecoil();

    public abstract void execute(Data data);
}
