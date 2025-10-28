package chainofresponsibility.advance.feedbackloop;

public class Test {
    public static void main(String args[]) {
        Handler h1 = new HandlerG1(1), h2 = new HandlerG2(2), h3 = new HandlerG3(3), h4 = new HandlerG4(4), h5 = new HandlerG5(5);
        Manager m = new Manager();
        HandleRegistry.put(h1.getID(), h1);
        HandleRegistry.put(h2.getID(), h2);
        HandleRegistry.put(h3.getID(), h3);
        HandleRegistry.put(h4.getID(), h4);
        HandleRegistry.put(h5.getID(), h5);
        LoadRegister.updateLoad(1, 0);
        LoadRegister.updateLoad(2, 0);
        LoadRegister.updateLoad(3, 0);
        LoadRegister.updateLoad(4, 0);
        LoadRegister.updateLoad(5, 0);
        Input input = new Input();
        for(int i = 0; i < 10; i++) {
            System.out.println("ITERATION : "+(i+1));
            m.initiate(input);
            LoadRegister.show();
        }
    }
}
