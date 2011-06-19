package net.arcreactor.chatty.packets.client;

import net.arcreactor.chatty.packets.Packet;
import org.apache.mina.core.buffer.IoBuffer;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 6/18/11
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class PongPacket extends Packet{
    public static final short HEADER = 0x1800;

    public PongPacket(){
        IoBuffer buffer = IoBuffer.allocate(2);
        buffer.putShort(HEADER);
        packet = buffer.array().clone();
    }

    @Override
    public short getHeader() {
        return HEADER;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
