
import java.util.ArrayDeque;
import java.util.Queue;

public class Bin {
    private final int binIndex;
    private final Queue<InputData> queue;

    public Bin(int index) {
        this.binIndex = index;
        this.queue = new ArrayDeque<>();
    }

    public int binIndex() {return this.binIndex;}
    public void flushIntoBin(InputData ip) {this.queue.offer(ip);}

    public void drain() {
        System.out.println("Drained from Bin : "+binIndex+" into the Drainage !!");
        Drainage.collect(queue);
    }
}
