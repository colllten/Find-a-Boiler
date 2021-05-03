import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client class that allows us to run program
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 5
 *
 * @author Sudhanva Bharadwaj, Colten Glover, Brayden Hall, Japneet Mavi, Jeff Woodhouse
 * @version May 3, 2021
 */

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
