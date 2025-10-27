package chainofresponsibility.advance.faulttolerantpipe;

// Use a static function to create objects from the factory
public class BinFactory {
    public static Bin createBin(int index) {
        return new Bin(index);
    }
}
