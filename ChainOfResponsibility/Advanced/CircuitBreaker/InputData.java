public class InputData {
    private int value;
    private final int fixed;

    public InputData(int fixed) {this.fixed = fixed;}

    public void setValue(int val) {this.value = val;}

    public int getValue() {return this.value;}
    public int getFixedValue() {return this.fixed;}

    public int random() {return (int)(Math.random()*100+1);}

    public void show() {
        System.out.println("Value : "+value);
        System.out.println("Fixed value : "+fixed);
    }
}
