import java.util.ArrayList;

public class UserDatabase {

    private ArrayList<User> users;
    private static int numUsers = 0;

    public int getNumUsers() {
        return numUsers;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
