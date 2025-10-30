package chainofresponsibility.extreme.multioutcomechain;

public class OutcomeManager {
    private final Cache cache;
    private final Registry registry;
    private final Extractor extractor;
    private final LoadBalancer balancer;
    private final FeedbackManager feedbackManager;

    public OutcomeManager(Cache cache, Registry registry, Extractor extractor, LoadBalancer balancer, FeedbackManager fm) {
        this.cache = cache; this.registry = registry; this.feedbackManager = fm;
        this.extractor = extractor; this.balancer = balancer;
    }

    public void initiateWork(Request request, Board board) {
        while(!cache.isQueueFull())
            feedbackManager.create();
        for(Cell cell : cache.queue()) {
            Model model = registry.getModel(cell.getID());
            Data data = model.execute(request);
            request = data.getRequest();
            if(data.isMissed())
                cell.miss();
            else
                cell.hits();
            extractor.feedIntoBoard(data, board);
            extractor.feedIntoLoadBalancer(data, balancer);
        }
        cache.process();
    }
}
