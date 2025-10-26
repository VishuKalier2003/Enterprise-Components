public class State {
    private String account;
    private int money, index;

    public State(String acc, int m) {this.account = acc; this.money = m; this.index = 0;}

    public void money(int money) {this.money = money;}
    public void account(String account) {this.account = account;}
    public void increaseIndex() {this.index++;}
    public void reduceIndex() {this.index--;}

    public int money() {return money;}
    public String account() {return account;}
    public int index() {return index;}

    public void show() {
        System.out.println("========STATE========");
        System.out.println("Account : "+account);
        System.out.println("Money : "+money);
        System.out.println("Index : "+index);
    }
}
