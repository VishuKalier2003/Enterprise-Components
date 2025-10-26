public class HandlerR2 implements Chain {
    private Chain next;
    private int order;
    private final int priority;

    public HandlerR2(int order, int priority) {
        this.order = order; this.priority = priority;
    }

    @Override
    public void setNext(Chain node) {this.next = node;}

    @Override
    public Chain getNext() {return this.next;}

    @Override
    public int getPriority() {return this.priority;}

    @Override
    public int getOrder() {return this.order;}

    @Override
    public void setOrder(int order) {this.order = order;}

    @Override
    public IOData execute(IOData input) {
        System.out.println("------Handler R2------");
        System.out.println("Order : "+order);
        System.out.println("Priority : "+priority);
        input.setData("Handler R2");
        if(Math.random() < 0.5)
            System.out.println(input.getData()+" passed !!");
        else
            System.out.println(input.getData()+" failed !!");
        return input;
    }
}
