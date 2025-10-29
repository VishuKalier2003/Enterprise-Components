package chainofresponsibility.extreme.multiphasechain;

public enum HandlerC implements HandlerTypeC {
    C1 {
        @Override public Data evaluate(Data data) {
            System.out.println("HandlerC.C1 evaluating data !!");
            if(data.getID().equals("DataC")) {
                DataC dC = data.as(DataC.class);
                dC.setData("Log: HandlerC.C1 processed the data. Feeding forward.");
                dC.setInfo("Log : Metric evaluation by C1");
                dC.setAmount(dC.getAmount() + 1000.45);
            }
            data.show();
            return data;
        }
        @Override public void setNext(Handler next) {
            C1.next = next;
        }
        @Override public Handler getNext() {
            return C1.next;
        }
    },
    C2 {
        @Override public Data evaluate(Data data) {
            System.out.println("HandlerC.C2 evaluating data !!");
            if(data.getID().equals("DataC")) {
                DataC dC = data.as(DataC.class);
                dC.setData("Log: HandlerC.C2 processed the data. Feeding forward.");
                dC.setInfo("Log : Metric evaluation by C2");
                dC.setAmount(dC.getAmount() + (22.0d/7.0d));
            }
            data.show();
            return data;
        }
        @Override public void setNext(Handler next) {
            C2.next = next;
        }
        @Override public Handler getNext() {
            return C2.next;
        }
    };

    private Handler next;
}
