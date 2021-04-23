import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class Notification extends JFrame {


    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        for (int i = 0; i < 100; i++) {
            users.add(new User("user" + i, "password", 1999, "User" + i, "Last" + i, null, null, null, false, null, "bio", "interests", null));
        }
        User u = new User("user32", "password", 1999, "User32", "Last32", null, null, null, true, null, "bio", "interests", null);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Notification n = new Notification(u, users);
            }
        });
    }

    public Notification(User u, ArrayList<User> users) {
        JFrame explore = new JFrame("Your Notifications");
        explore.setLocationRelativeTo(null);
        explore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        explore.setLayout(new BorderLayout());
        explore.setSize(500,500);
        String[] people = new String[users.size()];
        ArrayList<User> pendingUsers = new ArrayList<User>();
        pendingUsers.addAll(users);
        for (int i = 0; i < users.size(); i++) {
            String username = u.getUsername();
            User user = users.get(i);
            if (username.equals(user.getUsername())){
                pendingUsers.remove(i);
            }
        }

        ArrayList<JPanel> panels = new ArrayList<JPanel>();

        if (pendingUsers != null) {
            for (int i = 0; i < pendingUsers.size(); i++) {
                JPanel panel = new JPanel();
                JButton profileButton = new JButton("View Profile");
                int finalI = i;
                profileButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(pendingUsers.get(finalI).getUsername() + "'s Profile");
                    }
                });
                JButton acceptButton = new JButton("Accept");
                acceptButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(pendingUsers.get(finalI).getUsername() + " friend request");
                    }
                });

                JButton declineButton = new JButton("Decline");
                declineButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(pendingUsers.get(finalI).getUsername() + " friend request");
                    }
                });
                JLabel name = new JLabel(pendingUsers.get(i).getFirstName() + " " + pendingUsers.get(i).getLastName());
                if (pendingUsers.get(i).getFriends() != null) {
                    if (pendingUsers.get(i).getReceivedReqs().contains(u)) {
                        panel.add(name);
                        panel.add(profileButton);
                        panel.add(acceptButton);
                        panel.add(declineButton);
                    } else {
                        panel.add(name);
                        panel.add(profileButton);
                        panel.add(acceptButton);
                        panel.add(declineButton);
                    }
                } else {
                    panel.add(name);
                    panel.add(profileButton);
                    panel.add(acceptButton);
                    panel.add(declineButton);
                }
                panels.add(panel);
            }
        }

        JPanel panelScroll = new JPanel();
        panelScroll.setLayout(new GridLayout(panels.size(), 1));

        for (int i = 0; i < panels.size(); i++) {
            panelScroll.add(panels.get(i));
        }

        JScrollPane scrollPane = new JScrollPane(panelScroll);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        JPanel topPanel = new JPanel();
        JButton home = new JButton("Home");
        home.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                try {
                    explore.setVisible(false);
                    explore.dispose();
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


}