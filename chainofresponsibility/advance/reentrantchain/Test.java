package chainofresponsibility.advance.reentrantchain;

public class Test {
    public static void main(String args[]) {
        Handler x = new HandlerX(), y = new HandlerY(), z = new HandlerZ();
        Manager m = new Manager();
        m.insert(x);
        m.insert(y);
        m.insert(z);
        Data data = new Data();
        data.init();
        data.add(0);
        data.add(0);
        data.add(0);
        data.add(0);
        m.initiate(data);
    }
}
