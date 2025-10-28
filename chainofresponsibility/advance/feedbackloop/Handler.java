package chainofresponsibility.advance.feedbackloop;

public interface Handler {
    public FeedbackData feedback(int load);
    public int execute(Input input);
    public int getID();
}
