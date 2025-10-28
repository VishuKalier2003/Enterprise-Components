package chainofresponsibility.advance.cachechain;

public class BaseOutput implements Transferable {

    private String reqID;

    @Override public String getReqID() {return this.reqID;}
    public void setReqID(String s) {this.reqID = s;}
}
