package chainofresponsibility.advance.reentrantchain;

public class HandlerY extends Handler {

    @Override public void setNext(Handler next) {this.next = next;}
    @Override public void setRecoil(Handler recoil) {this.recoil = recoil;}
    @Override public Handler getNext() {return this.next;}
    @Override public Handler getRecoil() {return this.recoil;}

    @Override public void execute(Data data) {
        System.out.println("Handler Y executed !!");
        if(!data.getStatus().equals(Status.VALIDATED)) {
            boolean f = false;
            for(int i = 0; i < data.getValues().size(); i++) {
                data.set(i, (int)(Math.round(Math.random() * 10 + 1)));
                if(data.getValues().get(i) <= 10)
                    f = true;
            }
            if(!f)
                data.setStatus("CHECKED");
            else if(data.getStatus().equals(Status.CHECKED))
                data.setStatus("VALIDATED");
        }
        data.show();
    }
}
