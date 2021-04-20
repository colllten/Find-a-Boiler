import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static ArrayList<User> totalUsers = new ArrayList<>();
    public static ArrayList<User> activeUsers = new ArrayList<>();
    public static File userData = new File("UserData.txt");

    private static final int PORT = 9090;

    public static void main(String[] args) {
        ArrayList<User> adminFriends = new ArrayList<>();
        ArrayList<User> adminReceived = new ArrayList<>();
        ArrayList<User> adminSent = new ArrayList<>();
        ArrayList<User> adminNotifications = new ArrayList<>();
        String[] adminInterests = {"Football", "Basketball", "Video Games"};

        //Admin Login
        totalUsers.add(new User("admin", "admin", 0, "Admin", "Admin",
                adminFriends, adminSent, adminReceived, true, adminNotifications,
                "This is the Admin's bio", "admin@yahoo.com", adminInterests));

        // Test user
        ArrayList<User> testFriends = new ArrayList<>();
        ArrayList<User> testReceived = new ArrayList<>();
        ArrayList<User> testSent = new ArrayList<>();
        ArrayList<User> testNotifications = new ArrayList<>();
        String[] testInterests = {"Cards", "Swimming", "Running"};
        totalUsers.add(new User("test", "test", 2001, "test", "test",
                testFriends, testSent, testReceived, true, testNotifications, "Test bio",
                "test@yahoo.com", testInterests));
        //TODO to use the file to create users. MEANT FOR TAIL-END OF PROJECT
        /*

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("Test.txt")));
            String line; // Current line in the file
            String[] array = new String[2]; // Array for splitting the line
            //VARS FOR CREATING USER TO ADD TO TOTALUSERS//
            String username = "";
            String password = "";
            int birthYear = 0;
            String firstName = "";
            String lastName = "";
            ArrayList<User> friendsList = new ArrayList<>();
            ArrayList<User> sentList = new ArrayList<>();
            ArrayList<User> receivedList = new ArrayList<>();
            boolean online = false;
            ArrayList<User> notificationsList = new ArrayList<>();
            //VARS FOR CREATING USER TO ADD TO TOTALUSERS//
            while ((line = br.readLine()) != null) {
                if (line.contains("Username")) {
                    array = line.split(": ");
                    username = array[1];
                } else if (line.contains("Password")) {
                    array = line.split(": ");
                    password = array[1];
                } else if (line.contains("Birth Year")) {
                    array = line.split(": ");
                    birthYear = Integer.parseInt(array[1]);
                } else if (line.contains("First Name")) {
                    array = line.split(": ");
                    firstName = array[1];
                } else if (line.contains("Last Name")) {
                    array = line.split(": ");
                    lastName = array[1];
                } else if (line.contains("Friends")) {
                } else if (line.contains("Sent")) {
                } else if (line.contains("Received")) {
                } else if (line.contains("Online")) {
                    online = false;
                } else if (line.contains("Notifications")) {
                } else if (line.contains("Break")){
                    Server.totalUsers.add(new User(username, password, birthYear, firstName, lastName, friendsList, sentList, receivedList, online, notificationsList));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Issue finding file");
        } catch (IOException e) {
            System.err.println("Issue reading in Users");
        }

         */

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
