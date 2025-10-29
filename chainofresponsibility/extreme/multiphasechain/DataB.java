package chainofresponsibility.extreme.multiphasechain;

public class DataB implements Data {
    private String data, info;
    private int value;

    public void setData(String data) {this.data = data;}
    public void setInfo(String info) {this.info = info;}
    public void setValue(int value) {this.value = value;}

    public String getDataString() {return data;}
    public String getInfo() {return info;}
    public int getValue() {return value;}

    @Override public DataB getData() {return this;}
    @Override public String getID() {return "DataB";}
    @Override public void show() {
        System.out.println("DataB: data = " + data + ", info = " + info + ", value = " + value);
    }
}
