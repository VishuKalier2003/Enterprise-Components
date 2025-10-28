package chainofresponsibility.advance.feedbackloop;

public class FeedbackData {
    private int load, index;
    private boolean state;

    public void setLoad(int l) {this.load = l;}
    public void setIndex(int idx) {this.index = idx;}

    public int getLoad() {return this.load;}
    public int getIndex() {return this.index;}
    public boolean getState() {return this.state;}
}
