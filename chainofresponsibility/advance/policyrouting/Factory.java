package chainofresponsibility.advance.policyrouting;

import java.util.List;

public class Factory {

    public static Packet createEmptyPacket() {return new Packet();}
    public static IOData createInputPacket() {return new IOData();}
    public static Packet createFullPacket(List<Chain> handlers) {
        Packet packet = new Packet();
        int idx = 1;
        for(Chain handler : handlers)
            packet.addHandler(idx++, handler);
        return packet;
    }
}
