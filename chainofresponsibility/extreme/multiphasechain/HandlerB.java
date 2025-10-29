package chainofresponsibility.extreme.multiphasechain;

public enum HandlerB implements HandlerTypeB {
    B1 {
        @Override public Data execute(Data data) {
            System.out.println("HandlerB.B1 executing data !!");
            if(data.getID().equals("DataB")) {
                DataB dB = data.as(DataB.class);
                dB.setData("Log: HandlerB.B1 processed the data. Feeding forward.");
                dB.setInfo("Log : Internal execution by B1");
                dB.setValue(dB.getValue() - 1000);
            }
            data.show();
            return data;
        }
        @Override public void setNext(Handler next) {
            B1.next = next;
        }
        @Override public Handler getNext() {
            return B1.next;
        }
    },
    B2 {
        @Override public Data execute(Data data) {
            System.out.println("HandlerB.B2 executing data !!");
            if(data.getID().equals("DataB")) {
                DataB dB = data.as(DataB.class);
                dB.setData("Log: HandlerB.B2 processed the data. Feeding forward.");
                dB.setInfo("Log : Internal execution by B2");
                dB.setValue(dB.getValue() - 2000);
            }
            data.show();
            return data;
        }
        @Override public void setNext(Handler next) {
            B2.next = next;
        }
        @Override public Handler getNext() {
            return B2.next;
        }
    },
    B3 {
        @Override public Data execute(Data data) {
            System.out.println("HandlerB.B3 executing data !!");
            if(data.getID().equals("DataB")) {
                DataB dB = data.as(DataB.class);
                dB.setData("Log: HandlerB.B3 processed the data. Feeding forward.");
                dB.setInfo("Log : Internal execution by B3");
                dB.setValue(dB.getValue() / 20);
            }
            data.show();
            return data;
        }
        @Override public void setNext(Handler next) {
            B3.next = next;
        }
        @Override public Handler getNext() {
            return B3.next;
        }
    },;

    private Handler next;
}
