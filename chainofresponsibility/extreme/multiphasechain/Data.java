package chainofresponsibility.extreme.multiphasechain;

public interface Data {
    public Data getData();
    public String getID();
    default <T extends Data> T as(Class<T> clazz) {
        if (clazz.isInstance(this)) {
            return clazz.cast(this);
        }
        throw new IllegalArgumentException("Invalid Data Type: Expected " + clazz.getSimpleName());
    }
    public void show();
}

