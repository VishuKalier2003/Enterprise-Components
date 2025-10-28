package chainofresponsibility.advance.reentrantchain;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private Status status;
    private List<Integer> values;

    public void setStatus(String s) {this.status = Status.valueOf(s);}
    public Status getStatus() {return this.status;}

    public void init() {this.values = new ArrayList<>();}
    public void add(int idx) {this.values.add(idx);}
    public void set(int idx, int v) {this.values.set(idx, this.values.get(idx) + v);}
    public List<Integer> getValues() {return this.values;}

    public void show() {
        System.out.println(getStatus());
        System.out.println(getValues());
    }
}
