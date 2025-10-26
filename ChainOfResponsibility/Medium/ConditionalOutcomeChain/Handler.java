public interface Handler {
    public void setNextHandle(Handler handler);

    public Outcome initiate(Outcome outcome);

    public Handler next();
}
