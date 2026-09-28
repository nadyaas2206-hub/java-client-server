import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 8080;

        Socket socket = new Socket(host, port);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        String name = "Anna";
        out.println(name);
        System.out.println("Отправлено серверу: " + name);

        String response = in.readLine();
        System.out.println("Ответ сервера: " + response);

        socket.close();
    }
}
