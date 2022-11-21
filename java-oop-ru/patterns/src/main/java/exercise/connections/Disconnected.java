package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private TcpConnection tcpConnection;

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public void connect() {
        System.out.println("Connecting...");
        tcpConnection.setCurrentState(new Connected(tcpConnection));
    }

    @Override
    public void disconnect() {
        System.out.println("Error! Connection already disconnected.");
    }

    @Override
    public void write() {
        System.out.println("Error! Connection disconnected.");
    }

    @Override
    public String toString() {
        return "disconnected";
    }
}

// END
