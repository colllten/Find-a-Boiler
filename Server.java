import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static ArrayList<User> totalUsers = new ArrayList<>();
    public static ArrayList<User> activeUsers = new ArrayList<>();

    private static final int PORT = 9090;

    public static void main(String[] args) {

        try {
            ServerSocket socket = new ServerSocket(PORT);

            while (true) {
                System.out.println("[SERVER] Waiting for client connection...");
                Socket clientSocket = socket.accept();
                System.out.println("[SERVER] Successful Connection");
                ServerWorker worker = new ServerWorker(clientSocket);
                worker.start();
            }
        } catch (IOException e) {
            System.err.println("IOE #2 in Server");
        }
    }
}
