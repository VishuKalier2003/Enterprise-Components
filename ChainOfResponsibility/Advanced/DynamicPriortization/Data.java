public class Data {
    private final int ID;
    private final double LOAD;

    private Data(int id, double load) {
        this.ID = id;
        this.LOAD = load;
    }

    public static Data createData(int id, double load) {
        return new Data(id, load);
    }

    public int getID() {
        return this.ID;
    }

    public double getLOAD() {
        return this.LOAD;
    }
}
