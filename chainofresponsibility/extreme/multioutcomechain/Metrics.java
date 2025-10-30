package chainofresponsibility.extreme.multioutcomechain;

public interface Metrics {
    public int hits();
    public int miss();
    public int total();
    public double health();
    public Status status();
    public void setStatus(Status status);
}
