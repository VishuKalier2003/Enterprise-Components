package chainofresponsibility.extreme.multiphasechain;

public enum HandlerA implements HandlerTypeA {

    A1 {
        @Override public Data preprocess(Data data) {
            System.out.println("HandlerA.A1 preprocessing data !!");
            if(data.getID().equals("DataA")) {
                DataA dA = data.as(DataA.class);
                dA.setData("Log: HandlerA.A1 processed the data. Feeding forward.");
                dA.setSum(dA.getSum() + 100);
            }
            data.show();
            return data;
        }
        @Override public void setNext(Handler next) {
            A1.next = next;
        }
        @Override public Handler getNext() {
            return A1.next;
        }
    },
    A2 {
        @Override public Data preprocess(Data data) {
            System.out.println("HandlerA.A2 preprocessing data !!");
            if(data.getID().equals("DataA")) {
                DataA dA = data.as(DataA.class);
                dA.setData("Info: HandlerA.A2 processed the data. Feeding forward.");
                dA.setSum(dA.getSum() + 200);
            }
            data.show();
            return data;
        }
        @Override public void setNext(Handler next) {
            A2.next = next;
        }
        @Override public Handler getNext() {
            return A2.next;
        }
    }, A3 {
        @Override public Data preprocess(Data data) {
            System.out.println("HandlerA.A3 preprocessing data !!");
            if(data.getID().equals("DataA")) {
                DataA dA = data.as(DataA.class);
                dA.setData("Info: HandlerA.A3 processed the data. Feeding forward.");
                dA.setSum(dA.getSum() * 10);
            }
            data.show();
            return data;
        }
        @Override public void setNext(Handler next) {
            A3.next = next;
        }
        @Override public Handler getNext() {
            return A3.next;
        }
    };

    private Handler next;

}
