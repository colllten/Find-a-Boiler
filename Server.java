import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Server class that allows us to run program
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 5
 *
 * @author Sudhanva Bharadwaj, Colten Glover, Brayden Hall, Japneet Mavi, Jeff Woodhouse
 * @version May 3, 2021
 */

public class Server {

    public static ArrayList<User> totalUsers = new ArrayList<>();
    public static ArrayList<User> activeUsers = new ArrayList<>();

    private static final int PORT = 9090;

    public static ArrayList<User> getTotalUsers() {
        return totalUsers;
    }

    public static void main(String[] args) {
        ArrayList<User> adminFriends = new ArrayList<>();
        ArrayList<User> adminReceived = new ArrayList<>();
        ArrayList<User> adminSent = new ArrayList<>();
        ArrayList<User> adminNotifications = new ArrayList<>();
        ArrayList<String> adminInterests = new ArrayList<>();
        adminInterests.add("Football");
        adminInterests.add("Dancing");
        adminInterests.add("Singing");
        //Admin Login
        try {
            FileInputStream fis = new FileInputStream("UserData.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            totalUsers = (ArrayList<User>) ois.readObject();

            boolean isTaken = false;
            for (int i = 0; i < totalUsers.size(); i++) {
                if (totalUsers.get(i).getUsername().equals("admin")) {
                    isTaken = true;
                }
            }
            if (!isTaken) {
                totalUsers.add(new User("admin", "admin", 0, "Admin", "Admin",
                        adminFriends, adminSent, adminReceived, false, adminNotifications,
                        "This is the Admin's bio", "admin@yahoo.com", adminInterests, "public",
                        new JLabel("ProfilePic1.jfif")));
            }

            writeToFile();

        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ServerSocket socket = new ServerSocket(PORT);

            while (true) {
                writeToFile();
                Socket clientSocket = socket.accept();
                ServerWorker worker = new ServerWorker(clientSocket);
                worker.start();
                writeToFile();
            }
        } catch (IOException e) {
            System.err.println("IOE #2 in Server");
        }
    }

    public static void writeToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(new File("UserData.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Server.totalUsers);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
