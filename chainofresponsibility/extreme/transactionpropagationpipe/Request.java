package chainofresponsibility.extreme.transactionpropagationpipe;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String handlerID;
    private final Map<String, String> data;
    private int sum;
    private double amount;

    public Request() {this.data = new HashMap<>();}

    public void setSum(int s) {this.sum = s;}
    public void setAmount(double x) {this.amount = x;}
    public void setHandlerID(String s) {this.handlerID = s;}

    public Map<String, String> getData() {return this.data;}
    public int getSum() {return this.sum;}
    public double getAmount() {return this.amount;}
    public String getHandlerID() {return this.handlerID;}
}
