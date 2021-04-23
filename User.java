import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private int birthYear;
    private String firstName;
    private String lastName;
    private ArrayList<User> friends; // List of friends
    private ArrayList<User> sentReqs; // Sent friend requests
    private ArrayList<User> receivedReqs; // Received friend requests
    private boolean isOnline;
    private ArrayList<User> notifications;
    private String bio;
    private String email;
    private ArrayList<String> interests;

    public User(String username, String password, int birthYear, String firstName, String lastName,
                ArrayList<User> friends, ArrayList<User> sentReqs, ArrayList<User> receivedReqs, boolean isOnline,
                ArrayList<User> notifications, String bio, String email, ArrayList<String> interests) {
        this.username = username;
        this.password = password;
        this.birthYear = birthYear;
        this.firstName = firstName;
        this.lastName = lastName;
        this.friends = friends;
        this.sentReqs = sentReqs;
        this.receivedReqs = receivedReqs;
        this.isOnline = isOnline;
        this.notifications = notifications;
        this.bio = bio;
        this.email = email;
        this.interests = interests;
    }

    public User() {
        this.username = null;
        this.password = null;
        this.birthYear = 0;
        this.firstName = null;
        this.lastName = null;
        this.friends = null;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public ArrayList<User> getReceivedReqs() {
        return receivedReqs;
    }

    public ArrayList<User> getSentReqs() {
        return sentReqs;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public void removeReceivedNotification(User mainUser, User sentUser) {
        for (int i = 0; i < sentUser.receivedReqs.size(); i++) {
            if (sentUser.receivedReqs.get(i).equals(mainUser)) {
                sentUser.receivedReqs.remove(i);
                break;
            }
        }
    }

    public void sendFriendReq(User current, User rec) {
        current.sentReqs.add(rec);
        rec.receivedReqs.add(current);
    }

}