package chainofresponsibility.advance.feedbackloop;

import java.util.List;

public interface Configuration {
    public List<Integer> configure(List<int[]> loadIndex);
}
