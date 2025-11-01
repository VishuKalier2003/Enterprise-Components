package chainofresponsibility.extreme.transactionpropagationpipe;

public class Output {
    private Request request;
    private StatusCode code;
    private String text;

    public Output(Request req, StatusCode code) {this.request = req; this.code = code;}

    public void setRequest(Request req) {this.request = req;}
    public void setCode(StatusCode code) {this.code = code;}
    public void setText(String text) {this.text = text;}

    public Request getRequest() {return this.request;}
    public StatusCode getStatusCode() {return this.code;}
    public String getText() {return this.text;}
}
