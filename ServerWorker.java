import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

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
        OutputStream outputStream = clientSocket.getOutputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ArrayList<User> totalUsers = Server.totalUsers;
                ArrayList<User> friends = new ArrayList<>();
                ArrayList<User> received = new ArrayList<>();
                ArrayList<User> sent = new ArrayList<>();
                ArrayList<User> notifications = new ArrayList<>();

                Server.totalUsers.add(new User("admin", "admin", 2001, "Colten", "Glover", friends, sent, received, true, notifications));

                try {
                    LoginFrame lf = new LoginFrame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


    // OLD CODE BELOW
    /*
    private static String ip = "localhost";
    private static int port = 9090;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(ip, port);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            if (br.readLine().equals("Login")) {
                //ClientTesting user = new ClientTesting();

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        ArrayList<User> friends = new ArrayList<>();
                        ArrayList<User> received = new ArrayList<>();
                        ArrayList<User> sent = new ArrayList<>();
                        ServerTesting.users.add(new User("admin", "admin", 2001, "Colten", "Glover", friends, sent, received, true));

                        try {
                            LoginFrame lf = new LoginFrame();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     */
