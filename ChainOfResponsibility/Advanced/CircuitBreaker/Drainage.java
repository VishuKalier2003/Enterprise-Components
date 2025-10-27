
import java.util.ArrayDeque;
import java.util.Queue;

public class Drainage {
    private static final Queue<InputData> drainage = new ArrayDeque<>();

    public static void collect(Queue<InputData> q) {
        drainage.addAll(q);
    }

    public static int getDrainCount() {return drainage.size();}

    public static void completeDrain() {
        while(!drainage.isEmpty()) {
            System.out.println("Flushed from Drainage out of the system !!!");
            drainage.poll().show();
        }
    }
}
