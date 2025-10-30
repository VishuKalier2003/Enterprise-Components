package chainofresponsibility.extreme.multioutcomechain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Cache cache;
    private final List<Cell> board = new ArrayList<>();

    public Board(Cache cache) {this.cache = cache;}

    public void insert(int index) {
        Cell cell = new Cell("M"+index);
        insert(cell);
    }

    public void insert(Cell cell) {
        board.add(cell); updateState(size()-1, cell);
    }
    public int size() {return board.size();}

    public Cell extractCell(int index) {return board.get(index);}

    public void updateState(int index, Cell cell) {
        board.set(index, cell);
        if(putIntoCache(index, index))
            cache.extractCellFromBoard(cell);
    }

    public boolean checkIfInsert(int index) {return index >= board.size();}

    public boolean putIntoCache(int index, int load) {
        return board.get(index).health() > 0.75d;
    }

    public void show() {
        int idx = 0;
        for(Cell c : board) {
            System.out.println("Board Index "+(idx)+" : "+c.getID());
            idx++;
        }
    }
}
