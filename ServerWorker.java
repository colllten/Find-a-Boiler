import javax.swing.*;
import java.io.*;
import java.net.Socket;

/**
 * Class used to call the loginframe
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 5
 * @author Sudhanva Bharadwaj, Colten Glover, Brayden Hall, Japneet Mavi, Jeff Woodhouse
 * @version May 3, 2021
 */

public class ServerWorker extends Thread {

    private final Socket clientSocket;

    public ServerWorker(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            handleClientSocket();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void handleClientSocket() throws IOException, InterruptedException {
        InputStream inputStream = clientSocket.getInputStream();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrame lf = new LoginFrame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
