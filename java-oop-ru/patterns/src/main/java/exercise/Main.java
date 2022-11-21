package exercise;

public class Main {
    public static void main(String[] args) {
        // На вход принимаются ip-адрес и порт
        TcpConnection connection = new TcpConnection("132.223.243.88", 2342);
        connection.connect();
        System.out.println(connection.getCurrentState()); // "connected"
        connection.write("data");
        connection.disconnect();
        System.out.println(connection.getCurrentState()); // "disconnected"
        // Выводит на экран сообщение об ошибке
        connection.disconnect(); // => "Error! Connection already disconnected"
    }
}
