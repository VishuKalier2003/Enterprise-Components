package chainofresponsibility.extreme.transactionpropagationpipe;

import java.util.LinkedHashMap;

public class Storage {
    private final LinkedHashMap<String, StatusCode> codeMap;
    private final LinkedHashMap<String, String> logMap;

    public Storage() {
        this.codeMap = new LinkedHashMap<>();
        this.logMap = new LinkedHashMap<>();
    }

    public void log(Output output) {
        codeMap.put(output.getRequest().getHandlerID(), output.getStatusCode());
        logMap.put(output.getRequest().getHandlerID(), output.getText());
    }

    public void removeLast() {
        codeMap.remove(codeMap.lastEntry().getKey());
        logMap.remove(logMap.lastEntry().getKey());
    }

    public String extractLastHandlerID() {
        return codeMap.lastEntry().getKey();
    }

    public StatusCode extractLastStatus() {
        return codeMap.lastEntry().getValue();
    }

    public void show() {
        System.out.println("Code Map: "+codeMap);
    }
}
