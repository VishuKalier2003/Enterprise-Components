package chainofresponsibility.extreme.multiphasechain;

public class DataA implements Data {
    private String data;
    private int sum;

    public void setData(String data) {this.data = data;}
    public void setSum(int sum) {this.sum = sum;}

    public String getDataString() {return data;}
    public int getSum() {return sum;}

    @Override public DataA getData() {return this;}
    @Override public String getID() {return "DataA";}
    @Override public void show() {
        System.out.println("DataA: data = " + data + ", sum = " + sum);
    }
}
