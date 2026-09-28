import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        int port = 8080;

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен на порту " + port);

        Socket clientSocket = serverSocket.accept();
        System.out.println("New connection accepted");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
        );

        final String name = in.readLine();
        System.out.println("Получено имя от клиента: " + name);

        out.println(String.format("Hi %s, your port is %d",
                name, clientSocket.getPort()));

        clientSocket.close();
        serverSocket.close();
    }
}
