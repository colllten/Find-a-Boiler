import javax.swing.*;
import java.io.*;
import java.net.Socket;

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