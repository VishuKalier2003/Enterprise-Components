package chainofresponsibility.extreme.multioutcomechain;

public class FeedbackManager {
    private final Board board;
    private final LoadBalancer balancer;
    private final Registry registry;

    public FeedbackManager(Board board, LoadBalancer balancer, Registry registry) {
        this.board = board;
        this.balancer = balancer;
        this.registry = registry;
    }

    public void create() {
        System.out.println("According to Feedback, FEEDBACK MANAGER creates another Instance...");
        int r = (int)(Math.random() * 4) + 1;
        String id = "M"+board.size();
        Model model = Factory.factory(r, id);
        registry.register(id, model);
        balancer.updateLoad(id, 0);
        Cell cell = new Cell(id);
        board.insert(cell);
    }

    public void heal() {
        System.out.println("FEEDBACK MANAGER heals the cracked cells (Automated healing)...");
        for (int i = 0, j = 0; i < board.size(); i++) {
            if(j == 2)
                break;
            Cell cell = board.extractCell(i);
            if (cell.health() < 0.5d) {
                System.out.println("Healing Cell : "+cell.getID());
                cell.reset();
                balancer.updateLoad(cell.getID(), 0);
                j++;
            }
        }
    }
}
