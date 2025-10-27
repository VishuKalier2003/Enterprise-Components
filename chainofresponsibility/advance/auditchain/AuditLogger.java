package chainofresponsibility.advance.auditchain;

import java.util.LinkedList;
import java.util.Queue;

public class AuditLogger {
    private static final Queue<Auditable> queue = new LinkedList<>();

    public static void fuseIntoQueue(Auditable data) {queue.offer(data);}

    public static void drainLogger() {
        while(!queue.isEmpty()) {
            queue.poll().read();
        }
    }
}
