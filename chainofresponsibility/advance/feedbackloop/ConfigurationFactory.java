package chainofresponsibility.advance.feedbackloop;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ConfigurationFactory {
    public static final Configuration UNUSED_CONFIGURATION = loadIndex -> {
        System.out.println("-----UNUSED-CONFIGURATION INVOKED-----");
        List<Integer> data = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < loadIndex.size(); i++)
            if(loadIndex.get(i)[1] == 0 && count < 2) {
                data.add(loadIndex.get(i)[0]);
                count++;
            }
        return data;
    };

    public static final Configuration MIN_CONFIGURATION = loadIndex -> {
        System.out.println("-----MIN-CONFIGURATION INVOKED-----");
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        for(int data[] : loadIndex)
            min.add(data);
        List<Integer> data = new ArrayList<>();
        for(int i = 0; i < 3 && !min.isEmpty() && min.peek()[1] < 10; i++)
            data.add(min.poll()[0]);
        return data;
    };

    public static final Configuration OFF_CONFIGURATION = loadIndex -> {
        System.out.println("-----OFF-CONFIGURATION INVOKED-----");
        List<Integer> data = new ArrayList<>();
        data.add(-1);
        for(int li[] : loadIndex)
            if(li[1] < 15 && !LoadRegister.getState(li[0])) {
                LoadRegister.setState(li[0]);
                data.add(li[0]);
            } else if(li[1] >= 15)
                LoadRegister.setState(li[0]);
        return data;
    };
}
