package chainofresponsibility.advance.cachechain;

public class CacheOutput implements Transferable {
    private final BaseOutput baseOutput;
    private final Handler handler;
    private final int index;

    public CacheOutput(BaseOutput output, Handler handler, int index) {
        this.baseOutput = output;
        this.handler = handler;
        this.index = index;
    }

    @Override public String getReqID() {return this.baseOutput.getReqID();}

    public Handler get() {return this.handler;}
    public int getIndex() {return this.index;}
}
