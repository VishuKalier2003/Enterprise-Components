package chainofresponsibility.extreme.multioutcomechain;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {

    private final Queue<Cell> cells = new LinkedList<>();
    private final Queue<Cell> temp = new LinkedList<>();

    public void extractCellFromBoard(Cell cell) {
        if(cells.size() < 3)
            cells.add(cell);
    }

    public void callFeedbackManager(FeedbackManager fm) {
        if(cells.size() < 3) {
            fm.create();
        }
    }

    public void process() {
        System.out.println("processing...");
        for(Cell c : cells)
            if(c.health() > 0.75)
                temp.add(c);
        cells.clear();
        while(!temp.isEmpty())
            cells.add(temp.poll());
    }

    public boolean isEmpty() {return cells.isEmpty();}
    public Cell poll() {return cells.poll();}
    public boolean isQueueFull() {return cells.size() == 3;}
    public Queue<Cell> queue() {return cells;}
}
