package chainofresponsibility.advance.auditchain;

public class AuditData {
    private String log, handleID;
    private int status;
    private String message;

    public void setLog(String s) {this.log = s;}
    public void setMessage(String s) {this.message = s;}
    public void setHandleID(String s) {this.handleID = s;}
    public void setStatus(int i) {this.status = i;}

    public String getLog() {return this.log;}
    public String getHandleID() {return this.handleID;}
    public int getStatus() {return this.status;}
    public String getMessage() {return this.message;}
}
