package chainofresponsibility.extreme.multioutcomechain;

public class Cell implements Metrics {
    private Status status;
    private final String id;
    private int hits;
    private int miss;
    private int total;

    public Cell(String id) {
        this.status = Status.ACTIVE;
        this.hits = 0;
        this.miss = 0;
        this.total = 0;
        this.id = id;
    }

    @Override public int hits() {hits++; total(); return hits;}

    @Override public int miss() {miss++; total(); return miss;}

    @Override public int total() {total++; return total;}

    public void reset() {hits = 0; miss = 0; total = 0;}

    @Override public double health() {
        if (total == 0) {
            return 1.0d;
        }
        return (double) hits / total;
    }

    @Override public void setStatus(Status status) {this.status = status;}
    @Override public Status status() {return status; }
    public String getID() {return id;}
}
