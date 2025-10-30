package chainofresponsibility.extreme.multioutcomechain;

public interface Model {
    public String getID();
    public Data execute(Request request);
}
