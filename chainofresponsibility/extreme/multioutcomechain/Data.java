package chainofresponsibility.extreme.multioutcomechain;

public class Data {
    private Status status;
    private String id;
    private Request request;
    private int load;
    private boolean missed;

    public void setStatus(Status status) {
        this.status = status;
    }
    public Status getStatus() {
        return status;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setRequest(Request request) {
        this.request = request;
    }
    public Request getRequest() {
        return request;
    }
    public void setLoad(int load) {
        this.load = load;
    }
    public int getLoad() {
        return load;
    }
    public int getIndex() {
        return Integer.parseInt(id.substring(1));
    }
    public void setMissed(boolean missed) {
        this.missed = missed;
    }
    public boolean isMissed() {
        return missed;
    }
}
