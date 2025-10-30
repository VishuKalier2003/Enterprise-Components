package chainofresponsibility.extreme.multioutcomechain;

public class Factory {

    public static Model factory(int idx, String ID) {
        return switch (idx) {
            case 1 -> new ModelM1(ID);
            case 2 -> new ModelM2(ID);
            case 3 -> new ModelM3(ID);
            case 4 -> new ModelM4(ID);
            default -> throw new IllegalArgumentException("Invalid model index: " + idx);
        };
    }
}
