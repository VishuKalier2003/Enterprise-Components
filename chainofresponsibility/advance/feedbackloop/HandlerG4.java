package chainofresponsibility.advance.feedbackloop;

public class HandlerG4 implements Handler {
    private final int handlerIndex;

    public HandlerG4(int idx) {this.handlerIndex = idx;}

    @Override
    public FeedbackData feedback(int load) {
        FeedbackData data = new FeedbackData();
        data.setIndex(handlerIndex);
        data.setLoad(load);
        System.out.println("Feedback passed to Load Register from Handler G4 !!");
        return data;
    }

    @Override
    public int execute(Input input) {
        System.out.println("Handler G4 executed, accessing load !!");
        return (int)Math.round((Math.random()*10 + 1));
    }

    @Override public int getID() {return this.handlerIndex;}
}
