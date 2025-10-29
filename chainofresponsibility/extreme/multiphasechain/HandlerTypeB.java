package chainofresponsibility.extreme.multiphasechain;

public interface HandlerTypeB extends Linkable {
    public Data execute(Data data);
}
