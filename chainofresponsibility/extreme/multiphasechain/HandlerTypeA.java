package chainofresponsibility.extreme.multiphasechain;

public interface HandlerTypeA extends Linkable {
    public Data preprocess(Data data);
}
