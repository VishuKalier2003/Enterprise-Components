package chainofresponsibility.advance.faulttolerantpipe;

public class HandleManager {
    private HandlePipe head;

    public void addComponent(HandlePipe pipe, Bin bin) {
        if(head == null) {
            head = pipe;
            head.drainPipe(bin);
            return;
        }
        HandlePipe temp = head;
        while(temp.handlePipe() != null)
            temp = temp.handlePipe();
        temp.handlePipe(pipe);
        temp.drainPipe(bin);
    }

    public void initiate(InputData input) {
        HandlePipe temp = head;
        while(temp != null) {
            if(temp.execute(input))
                temp = temp.handlePipe();
            else {
                temp.drainPipe().flushIntoBin(input);
                temp.drainPipe().drain();
                break;
            }
        }
    }
}
