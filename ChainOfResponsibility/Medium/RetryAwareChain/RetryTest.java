public class RetryTest {
    public static void main(String[] args) {
        RetryQueue rq = new RetryQueue();
        RetryChainProducer producer = new RetryChainProducer(rq);
        producer.addHandle(new HandlerA());
        producer.addHandle(new HandlerB(rq));
        producer.addHandle(new HandlerC());
        producer.addHandle(new HandlerD());
        producer.addHandle(new HandlerE(rq));
        producer.initiateProcess(producer.getHead(), "Testing\n", false);
    }
}
