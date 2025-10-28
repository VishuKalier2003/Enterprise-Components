package chainofresponsibility.advance.cachechain;

public interface Cacheable {
    public void register(String reqID, int statusCode);
    public int get(String reqID);
}
