
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public enum PolicyEvaluator implements Policy {
    ASCENDING {
        @Override
        public Packet arrange(Packet input) {
            System.out.println("Ascending policy taken");
            PriorityQueue<Chain> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.getPriority(), b.getPriority()));
            for(Map.Entry<Integer, Chain> e : input.get().entrySet())
                minHeap.offer(e.getValue());
            int c = 0;
            Packet packet = Factory.createEmptyPacket();
            while(c < 3)
                packet.addHandler(c++, minHeap.poll());
            return packet;
        }
    },
    DESCENDING {
        @Override
        public Packet arrange(Packet input) {
            System.out.println("Descending policy taken");
            PriorityQueue<Chain> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.getPriority(), a.getPriority()));
            for(Map.Entry<Integer, Chain> e : input.get().entrySet())
                minHeap.offer(e.getValue());
            int c = 0;
            Packet packet = Factory.createEmptyPacket();
            while(c < 3)
                packet.addHandler(c++, minHeap.poll());
            return packet;
        }
    },
    RANDOM {
        @Override
        public Packet arrange(Packet input) {
            System.out.println("Random policy taken");
            Set<Integer> taken = new HashSet<>();
            while(taken.size() < 2) {
                int v = (int)Math.ceil(Math.random()*3 + 1);
                taken.add(v);
            }
            Packet packet = Factory.createEmptyPacket();
            int c = 1;
            while(c < 3)
                packet.addHandler(c, input.get(c++));
            return packet;
        }
    };
}
