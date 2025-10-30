package chainofresponsibility.extreme.multioutcomechain;

public class Extractor {

    public void feedIntoLoadBalancer(Data data, LoadBalancer balancer) {
        balancer.updateLoad(data.getId(), data.getLoad());
    }

    public void feedIntoBoard(Data data, Board board) {
        if(data.getIndex() >= board.size()) {
            Cell cell = new Cell(data.getId());
            board.insert(cell);
        } else {
            int index = data.getIndex();
            Cell cell = board.extractCell(index);
            if(data.isMissed())
                cell.miss();
            else
                cell.hits();
            board.updateState(index, cell);
        }
    }
}
