package chainofresponsibility.extreme.multioutcomechain;

public class ModelM3 implements Model {
    private final String id; private int load;

    public ModelM3(String id) {this.id = id;}

    @Override public String getID() {return id;}

    @Override public Data execute(Request request) {
        load += (int)(Math.round(Math.random() * 10) + 1);
        boolean flag = Math.random() > 0.5;
        System.out.println("Handler M3 executed with load : "+load+" and flag : "+flag);
        Data data = new Data();
        data.setId(id);
        data.setLoad(load);
        data.setMissed(flag);
        data.setRequest(request);
        data.setStatus(data.isMissed() ? Status.CRASHED : Status.ACTIVE);
        return data;
    }

}
