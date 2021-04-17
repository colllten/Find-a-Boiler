import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private static String ip = "localhost";
    private static int port = 9090;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(ip, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
