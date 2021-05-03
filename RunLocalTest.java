import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * All of our automatic tests as well as descriptions of manual tests for the methods that
 * cannot be tested automatically.
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 5
 *
 * @author Sudhanva Bharadwaj, Colten Glover, Brayden Hall, Japneet Mavi, Jeff Woodhouse
 * @version May 3, 2021
 */
public class RunLocalTest {


    //There are no failing tests for any of the setters. The only time they would be handling
    //invalid input is if the input types were wrong. For example, User.setUsername(String username)
    //requires a String, but if an Integer were input, the code would not compile and therefore
    //the error would occur. If the code compiles, the setters would not be handling invalid
    //input therefore there are no failing tests for the setters.

    //Methods without automatic tests:

    //Server.writeToFile()
    //This will fail the first time it runs. It does not take in any inputs, so every time
    //it writes to UserData.txt. The first time the code runs, UserData.txt does not exist
    //so it fails. However, it then creates the file so the next time the server is run, it will work.
    //The passing test would be any time it runs after the first time.

    //ServerWorker.handleClientSocket()
    //This will pass the test any time it runs. The only time it would fail is if there is
    //an interrupted exception, which is hard to replicate using JUnit.

    //All constructors other than User()
    //These are all GUI based and therefore cannot have automatic tests. The constructors would
    //all fail if they were given a null user. However, they all work on all other cases. In the video,
    //we provide a more in depth discussion into more of the testing / handling user errors to make sure
    //that all of the information they enter is correct and can be processed correctly by our methods.

    ArrayList<User> adminFriends = new ArrayList<>();
    ArrayList<User> adminReceived = new ArrayList<>();
    ArrayList<User> adminSent = new ArrayList<>();
    ArrayList<User> adminNotifications = new ArrayList<>();
    ArrayList<String> adminInterests = new ArrayList<String>();

    User u = new User("admin", "admin", 0, "Admin", "Admin",
            adminFriends, adminSent, adminReceived, false, adminNotifications,
            "This is the Admin's bio", "admin@yahoo.com", adminInterests, "public", new JLabel("ProfilePic1.jfif"));
    User u1 = new User("admin1", "admin", 0, "Admin1", "Admin1",
            adminFriends, adminSent, adminReceived, false, adminNotifications,
            "This is the Admin's bio", "admin@yahoo.com", adminInterests, "public", new JLabel("ProfilePic1.jfif"));
    User u2 = null;

    //this is the passing test for User.getInterests()
    @Test
    public void UserGetInterestsTestPass(){
        ArrayList<String> result = u.getInterests();
        assertEquals(new ArrayList<String>(), result);
    }
    //this is the failing test for User.getInterests()
    @Test
    public void UserGetInterestsTestFail(){
        boolean hey = true;
        try{
            u2.getInterests();
        } catch(NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for the User constructor
    @Test
    public void UserConstructorPass(){
        User u3 = new User("admin", "admin", 0, "Admin", "Admin",
                adminFriends, adminSent, adminReceived, false, adminNotifications,
                "This is the Admin's bio", "admin@yahoo.com", adminInterests, "public",
                new JLabel("ProfilePic1.jfif"));
        boolean hey = u.getUsername().equals(u3.getUsername());
        assertEquals(true, hey);
    }
    //this is the failing test for the User constructor
    @Test
    public void UserConstructorFail(){
        User u3 = new User();
        boolean hey = true;
        try{
            u3.getUsername().equals(u.getUsername());
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.getUsername
    @Test
    public void getUserNamePass(){
        assertEquals("admin", u.getUsername());
    }
    //this is the failing test for User.getUsername
    @Test
    public void getUserNameFail(){
        boolean hey = true;
        try{
            u2.getUsername();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.getPassword
    @Test
    public void getPasswordPass(){
        assertEquals("admin", u.getPassword());
    }
    //this is the failing test for User.getPassword
    @Test
    public void getPasswordFail(){
        boolean hey = true;
        try{
            u2.getPassword();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.getBirthYear()
    @Test
    public void getBirthYearPass(){
        assertEquals(0, u.getBirthYear());
    }
    //this is the failing test for User.getBirthYear()
    @Test
    public void getBirthYearFail(){
        boolean hey = true;
        try{
            u2.getBirthYear();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.getFirstName()
    @Test
    public void getFirstNamePass(){
        assertEquals("Admin", u.getFirstName());
    }
    //this is the failing test for User.getFirstName()
    @Test
    public void getFirstNameFail(){
        boolean hey = true;
        try{
            u2.getFirstName();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.getLastName()
    @Test
    public void getLastNamePass(){
        assertEquals("Admin", u.getLastName());
    }
    //this is the failing test for User.getLastName()
    @Test
    public void getLastNameFail(){
        boolean hey = true;
        try{
            u2.getLastName();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.getFriends()
    @Test
    public void getFriendsPass(){
        assertEquals(new ArrayList<User>(), u.getFriends());
    }
    //this is the failing test for User.getFriends()
    @Test
    public void getFriendsFail(){
        boolean hey = true;
        try{
            u2.getFriends();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.getReceivedRequests
    @Test
    public void getReceivedRequestsPass(){
        assertEquals(new ArrayList<User>(), u.getReceivedReqs());
    }
    //this is the failing test for User.getReceivedRequests
    @Test
    public void getReceievedRequestsFail(){
        boolean hey = true;
        try{
            u2.getReceivedReqs();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.getSentReqs
    @Test
    public void getSentRequestsPass(){
        assertEquals(new ArrayList<User>(), u.getSentReqs());
    }
    //this is the failing test for User.getSentReqs
    @Test
    public void getSentRequestsFail(){
        boolean hey = true;
        try{
            u2.getSentReqs();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.isOnline
    @Test
    public void isOnlinePass(){
        assertEquals(false, u.isOnline());
    }
    //this is the failing test for User.isOnline
    @Test
    public void isOnlineFail(){
        boolean hey = true;
        try{
            u2.isOnline();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.getNotifications
    @Test
    public void getNotificationsPass(){
        assertEquals(new ArrayList<User>(), u.getNotifications());
    }
    //this is the failing test for User.getNotifications
    @Test
    public void getNotificationsFail(){
        boolean hey = true;
        try{
            u2.getNotifications();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.getEmail
    @Test
    public void getEmailPass(){
        assertEquals("admin@yahoo.com", u.getEmail());
    }
    //this is the failing test for User.getEmail
    @Test
    public void getEmailFail(){
        boolean hey = true;
        try{
            u2.getEmail();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.getVisibility
    @Test
    public void getVisibilityPass(){
        assertEquals("public", u.getVisibility());
    }
    //this is the failing test for User.getVisibility
    @Test
    public void getVisibilityFail(){
        boolean hey = true;
        try{
            u2.getVisibility();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.cancelNotification
    @Test
    public void cancelNotificationPass(){
        u.getSentReqs().add(u1);
        u1.getReceivedReqs().add(u);
        boolean hey = true;
        try{
            u.cancelNotification(u, u1);
        } catch(NullPointerException e) {
            hey = false;
        }
        assertEquals(true, hey);
    }
    @Test
    public void cancelNotificationFail(){
        boolean hey = true;
        try{
            u.cancelNotification(u, u2);
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.removeAccDec
    @Test
    public void removePass(){
        u.sendFriendReq(u, u1);
        boolean hey = true;
        try {
            u.removeAccDec(u1, u);
        } catch (Exception e) {
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the failing test for User.removeAccDec
    @Test
    public void removeFail(){
        boolean hey = true;
        try{
            u.removeAccDec(u, u2);
        } catch (NullPointerException e){
            hey = false;
        } catch(IndexOutOfBoundsException j){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.sendFriendReq
    @Test
    public void sendPass(){
        int length;
        u.getSentReqs().clear();
        u1.getReceivedReqs().clear();
        try {
            u.sendFriendReq(u, u1);
            length = u.getSentReqs().size();
        } catch (Exception e) {
            length = 0;
        }
        assertEquals(1, length);
    }
    //this is the failing test for User.sendFriendReq
    @Test
    public void sendFail(){
        boolean hey = true;
        try{
            u.sendFriendReq(u, u2);
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.toString
    @Test
    public void toStringPass(){
        assertEquals("admin", u.toString());
    }
    //this is the failing test for User.toString
    @Test
    public void toStringFail(){
        boolean hey = true;
        try{
            u2.toString();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.getIcon
    @Test
    public void iconPass(){
        boolean hey;
        JLabel j1 = new JLabel("ProfilePic1.jfif");
        try {
            JLabel j = u.getIcon();
            hey = j.getText().equals(j1.getText());
        } catch (Exception e) {
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the failing test for User.getIcon
    @Test
    public void iconFail(){
        boolean hey = true;
        try{
            u2.getIcon();
        } catch (NullPointerException e){
            hey = false;
        }
        assertEquals(true, hey);
    }
    //this is the passing test for User.setUsername
    @Test
    public void setUsernamePass(){
        u.setUsername("hello");
        assertEquals("hello", u.getUsername());
    }
    //this is the passing test for User.setPassword
    @Test
    public void setPasswordPass(){
        u.setPassword("12345");
        assertEquals("12345", u.getPassword());
    }
    //this is the passing test for User.setBirthYear
    @Test
    public void setBirthYearPass(){
        u.setBirthYear(1);
        assertEquals(1, u.getBirthYear());
    }
    //this is the passing test for User.setFirstName
    @Test
    public void setFirstNamePass(){
        u.setFirstName("George");
        assertEquals("George", u.getFirstName());
    }
    //this is the passing test for User.setLastName
    @Test
    public void setLastNamePass(){
        u.setLastName("Washington");
        assertEquals("Washington", u.getLastName());
    }
    //this is the passing test for User.setBio
    @Test
    public void setBioPass(){
        u.setBio("What's up everyone?");
        assertEquals("What's up everyone?", u.getBio());
    }
    //this is the passing test for User.setEmail
    @Test
    public void setEmailPass(){
        u.setEmail("coolguy123@gmail.com");
        assertEquals("coolguy123@gmail.com", u.getEmail());
    }
    //this is the passing test for User.setOnline
    @Test
    public void setOnlinePass(){
        u.setOnline(true);
        assertEquals(true, u.isOnline());
    }
    //this is the passing test for User.setVisibility
    @Test
    public void setVisibilityPass(){
        u.setVisibility("private");
        assertEquals("private", u.getVisibility());
    }
    //this is the passing test for User.setIcon
    @Test
    public void setIconPass(){
        u.setIcon(new JLabel("ProfilePic2.jfif"));
        assertEquals("ProfilePic2.jfif", u.getIcon().getText());
    }

}
