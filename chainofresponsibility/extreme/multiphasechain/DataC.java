package chainofresponsibility.extreme.multiphasechain;

public class DataC implements Data {
    private String data, info;
    private double amount;

    public void setData(String data) {this.data = data;}
    public void setInfo(String info) {this.info = info;}
    public void setAmount(double amount) {this.amount = amount;}

    public String getDataString() {return data;}
    public String getInfo() {return info;}
    public double getAmount() {return amount;}

    @Override public DataC getData() {return this;}
    @Override public String getID() {return "DataC";}
    @Override public void show() {
        System.out.println("DataC: data = " + data + ", info = " + info + ", amount = " + amount);
    }

}
