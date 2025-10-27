package chainofresponsibility.advance.exceptionescalationchain;

public class Data {
    private String input;
    private int sum;

    public Data(String s) {this.input = s; this.sum = 0;}

    public void setInput(String s) {this.input = s;}
    public void setSum(int s) {this.sum = s;}

    public String getInput() {return input;}
    public int getSum() {return sum;}

    public void show() {
        System.out.println("Data input : "+input);
        System.out.println("Data sum : "+sum);
    }
}
