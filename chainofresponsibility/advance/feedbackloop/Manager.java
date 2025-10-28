package chainofresponsibility.advance.feedbackloop;

import java.util.List;

public class Manager {
    public void collect(FeedbackData data) {
        LoadRegister.updateLoad(data.getIndex(), data.getLoad());
    }

    public void initiate(Input input) {
        List<Integer> index = HandleStrategy.strategy();
        if (index.isEmpty())
            return;
        if (index.get(0) == -1) {
            for (int i = 1; i < index.size(); i++) {
                int handlerId = index.get(i);
                Handler handler = HandleRegistry.get(handlerId);
                if (handler != null)
                    collect(handler.feedback(handler.execute(input)));
            }
        } else {
            for (int handlerId : index) {
                Handler handler = HandleRegistry.get(handlerId);
                if (handler != null)
                    collect(handler.feedback(handler.execute(input)));
            }
        }
    }
}
