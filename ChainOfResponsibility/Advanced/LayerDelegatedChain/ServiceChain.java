public interface ServiceChain extends Chainable<ServiceChain> {
    public boolean executeService(InputOutput input);
}
