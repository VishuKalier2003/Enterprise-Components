public class Metrics {
    private int load, fired;
    private final int handlerID;
    private double loadRatio;

    public Metrics(int ID) {this.handlerID = ID;}

    public void setLoad(int load) {this.load += load; setLoadRatio();}
    public void setFired() {this.fired++; setLoadRatio();}
    public void setLoadRatio() {this.loadRatio = this.load/(this.fired+0.0d);}

    public int getLoad() {return this.load;}
    public int getFired() {return this.fired;}
    public double getLoadRatio() {return this.loadRatio;}
    public int getHandlerID() {return this.handlerID;}
}
