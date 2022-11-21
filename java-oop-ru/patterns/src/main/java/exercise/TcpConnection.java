package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

// BEGIN
public class TcpConnection {
    private Connection connection;
    private final String host;
    private final int port;

    public TcpConnection(String host, int port) {
        this.connection = new Disconnected(this);
        this.host = host;
        this.port = port;
    }

    public String getCurrentState() {
        return connection.toString();
    }

    public void setCurrentState(Connection connection) {
        this.connection = connection;
    }

    public void connect() {
        connection.connect();
    }

    public void disconnect() {
        connection.disconnect();
    }

    public void write(String data) {
        connection.write();
    }
}

// END
