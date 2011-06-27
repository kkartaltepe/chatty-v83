package net.arcreactor.chatty;

import net.arcreactor.chatty.packets.AbstractPacket;
import net.arcreactor.chatty.packets.client.ServerStatusRequestPacket;
import net.arcreactor.chatty.packets.client.PongPacket;
import net.arcreactor.chatty.packets.server.LoginStatusPacket;
import net.arcreactor.chatty.packets.server.PingPacket;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 6/18/11
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChattyHandler extends IoHandlerAdapter {

    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("Created an IO Session with something!");
    }

    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("Closed an IO Session with something!");
        session.close(true);
    }

    public void messageReceived(IoSession session, Object message) throws Exception {
        AbstractPacket received = (AbstractPacket)message;
        switch(received.getHeader()){
            case PingPacket.HEADER:
                session.write(new PongPacket().getPacketBytes());
                System.out.println("Ping pong!");
                break;
            case LoginStatusPacket.HEADER:
                System.out.println("Login status: " + ((LoginStatusPacket)received).getResponse());
                break;
            case ServerStatusRequestPacket.HEADER:
                break;
            default:
                System.out.println(received);
                break;
        }
    }

    public void messageSent(IoSession session, Object message) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
