import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class ExploreUpdate extends JFrame {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            User u = new User("user" + i, "user", 2000, "User", "Last", new ArrayList<User>(),
                    new ArrayList<User>(), new ArrayList<User>(), false, new ArrayList<User>(),
                    "bio", "email@email.com", new ArrayList<String>(), "public");
            users.add(u);
        }
        ExploreUpdate exploreUpdate = new ExploreUpdate(users.get(12));
    }

    //create new explore object
    public ExploreUpdate(User u) {
        Timer timer = new Timer();
        JFrame explore = new JFrame("Explore");

        explore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        explore.setLayout(new BorderLayout());
        explore.setSize(500,500);

        //creates a new timer task to automatically update the frame
        TimerTask task = new TimerTask() {
            public void run() {
                //retrieve the list of all users from the server
                ArrayList<User> users = Server.getTotalUsers();
                ArrayList<User> otherUsers = new ArrayList<>();
                otherUsers.addAll(users);
                //remove current user and any private users from list of all visible users
                for (int i = 0; i < users.size(); i++) {
                    String username = u.getUsername();
                    User user = users.get(i);
                    if (username.equals(user.getUsername())){
                        otherUsers.remove(i);
                    }
                    if (user.getVisibility().equals("private")){
                        otherUsers.remove(i);
                    }
                }

                ArrayList<JPanel> panels = new ArrayList<JPanel>();
                //create a JPanel for each user
                if (otherUsers != null) {
                    for (int i = 0; i < otherUsers.size(); i++) {
                        JPanel panel = new JPanel();
                        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
                        JButton profileButton = new JButton("View Profile");
                        int finalI = i;
                        User user = otherUsers.get(i);

                        //create button to view user profile
                        profileButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                explore.setVisible(false);
                                explore.dispose();
                                timer.cancel();
                                MyProfile profile = new MyProfile(otherUsers.get(finalI));
                            }
                        });

                        //create a button to send a friend request
                        JButton friendReqButton = new JButton("Send Friend Request");
                        friendReqButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // NEW FRIEND REQUEST METHOD IN USE //
                                System.out.println(user.getUsername() + " friend request");
                                u.sendFriendReq(u, user);
                                System.out.println("Main User sent request" + u.getSentReqs().get(0));
                                System.out.println("Receiver received: " + user.getReceivedReqs().get(0));
                                // NEW FRIEND REQUEST METHOD IN USE //
                            }
                        });

                        //create a new JLabel to display the user's name
                        JLabel name = new JLabel(user.getFirstName() + " " + user.getLastName());
                        panel.add(name);

                        //if the user is public, add buttons to see their profile and send a friend request...
                        //...if the users aren't already friends
                        if (user.getVisibility().equals("public")) {
                            if (user.getFriends().contains(u)) {
                                panel.add(profileButton);
                            } else {
                                panel.add(profileButton);
                                panel.add(friendReqButton);
                            }
                            //if the user is private, add a button to send a friend request if users are not friends
                            //and if they are friends add a button to view profile
                        } else if (user.getVisibility().equals("private")){
                            if (user.getFriends().contains(u)) {
                                panel.add(profileButton);
                            } else {
                                panel.add(friendReqButton);
                            }
                        }
                        JLabel online = new JLabel("Online");
                        if (user.isOnline()){
                            panel.add(online);
                        }
                        panels.add(panel);
                    }
                }

                //create a JScrollPane to contain all of the Jpanels created for each user
                JPanel panelScroll = new JPanel();
                panelScroll.setLayout(new GridLayout(panels.size(), 1));

                for (int i = 0; i < panels.size(); i++) {
                    panelScroll.add(panels.get(i));
                }

                JScrollPane scrollPane = new JScrollPane(panelScroll);
                scrollPane.getVerticalScrollBar().setUnitIncrement(16);

                //add other panels and buttons to make it look pretty and be able to go home
                JPanel topPanel = new JPanel();
                JButton home = new JButton("Home");
                home.addActionListener(new ActionListener () {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            explore.setVisible(false);
                            explore.dispose();
                            timer.cancel();
                            MainPage main = new MainPage(u);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                });
                topPanel.add(home);
                explore.add(topPanel, BorderLayout.NORTH);
                explore.add(scrollPane);
                explore.setVisible(true);
            }
        };
        //this line is very important: it needs to be after the TimerTask otherwise the position keeps...
        //... updating every time the frame updates which is annoying
        explore.setLocationRelativeTo(null);
        //this schedules the TimerTask to run every 0.1 seconds while the explore page is up
        timer.scheduleAtFixedRate(task, 0, 100);
    }
}