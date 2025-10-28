package chainofresponsibility.advance.feedbackloop;

import java.util.ArrayList;
import java.util.List;

public class HandleStrategy {

    public static List<Integer> strategy() {
        List<Integer> unused = ConfigurationFactory.UNUSED_CONFIGURATION.configure(LoadRegister.getAbstractLoadMap());
        if(unused.size() < 2)
            unused = ConfigurationFactory.MIN_CONFIGURATION.configure(LoadRegister.getAbstractLoadMap());
        if(unused.size() < 2)
            unused = ConfigurationFactory.OFF_CONFIGURATION.configure(LoadRegister.getAbstractLoadMap());
        if(unused.size() == 1 && unused.get(0) == -1) {
            System.out.println("EMPTY passed");
            return new ArrayList<>();
        }
        return unused;
    }
}
