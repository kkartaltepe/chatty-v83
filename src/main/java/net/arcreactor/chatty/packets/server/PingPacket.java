package net.arcreactor.chatty.packets.server;

import net.arcreactor.chatty.packets.AbstractPacket;
import org.apache.mina.core.buffer.IoBuffer;

import java.nio.ByteOrder;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 6/18/11
 * Time: 9:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class PingPacket extends AbstractPacket {
    public static final short HEADER = 0x11;

    public PingPacket(){
        IoBuffer buffer = IoBuffer.allocate(2);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putShort(HEADER);
        packet = buffer.array().clone();
    }

    public PingPacket(byte[] content){
        this.packet = content.clone();
    }

    public short getHeader() {
        return HEADER;
    }
}
