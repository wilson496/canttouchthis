/*package ctttest.net;

import ctttest.net.NetUtilityThreads.*;

import canttouchthis.common.Message;
import canttouchthis.server.ServerSession;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import junit.framework.*;
*/
/**
 * Tests the ServerSession object against a generic websocket client.
 */
 /*
public class TestServerSession extends TestCase {

    ServerSession session;

    public void setUp() throws Exception {
        super.setUp();
        session = new ServerSession();
    }

    public void tearDown() {
        session.close();
    }

    /**
     * Server should accept incoming connections.
     * @throws UnknownHostException If localhost cannot be found.
     */
     /*
    public void testServerAcceptsConnection() throws UnknownHostException {

        InetAddress addr = InetAddress.getLocalHost();
        TryConnect conThread = new TryConnect(addr, ServerSession.DEFAULT_PORT, false);

        conThread.start();
        boolean success = session.waitForConnection();

        try {
            conThread.join();
        }
        catch (InterruptedException ex) {
            assertTrue("Connection thread interrupted!", false);
        }

        assertTrue(success);

    }
*/
    /**
     * Checks that messages are serialized properly and can be read by a client.
     */
/*    public void testMessageSerialization() throws UnknownHostException {
        // SETUP
        ChatMessage m = new ChatMessage("This is a test!!!", 0);
        TryConnect conThread = new TryConnect(InetAddress.getLocalHost(), ServerSession.DEFAULT_PORT, true);

        // EXEC
        conThread.start();
        assertTrue(session.waitForConnection());
        boolean success = true;
        try {
            session.sendMessage(m);
        }
        catch (IOException ex) {
            success = false;
        }

        try {
            conThread.join();
        }
        catch (InterruptedException ex) {
            assertTrue("Connection thread interrupted!", false);
        }

        ChatMessage recv = conThread.message;

        // VERIFY
        assertTrue(success);
        assertEquals(m.message, recv.message);
        assertTrue(m.timestamp.equals(recv.timestamp));
    }

}
*/
