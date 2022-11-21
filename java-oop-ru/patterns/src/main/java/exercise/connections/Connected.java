package exercise.connections;

import exercise.TcpConnection;

// BEGIN
class Connected implements Connection {
    private TcpConnection tcpConnection;

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public void connect() {
        System.out.println("Error! Connection already connected.");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting...");
        tcpConnection.setCurrentState(new Disconnected(tcpConnection));
    }

    @Override
    public void write() {
    }

    @Override
    public String toString() {
        return "connected";
    }
}
// END
