public class TestingBreaker {
    public static void main(String[] args) {
        HandlePipe a = new HandleA(), b = new HandleB(), c = new HandleC(), d = new HandleD();
        Bin b1 = BinFactory.createBin(1), b2 = BinFactory.createBin(2);
        HandleManager hm = new HandleManager();
        hm.addComponent(a, b1);
        hm.addComponent(b, b1);
        hm.addComponent(c, b2);
        hm.addComponent(d, b2);
        InputData input = new InputData(0);
        for(int i = 0; i < 5; i++) {
            hm.initiate(input);
            System.out.println("Drainage size : "+Drainage.getDrainCount());
        }
        Drainage.completeDrain();
    }
}
