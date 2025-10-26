public class Test4 {
    public static void main(String[] args) {
        final InputHandle a = new TesterA(), b = new TesterB(), c = new TesterC();
        TransactionManager manager = new TransactionManager();
        manager.addInputHandle(a);
        manager.addInputHandle(b);
        manager.addInputHandle(c);
        manager.initiate(new State("Acc-00000476", 1000));
    }
}
