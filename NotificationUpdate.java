import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class for notifications that displays to users their outgoing and incoming friend requests
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 5
 *
 * @author Sudhanva Bharadwaj, Colten Glover, Brayden Hall, Japneet Mavi, Jeff Woodhouse
 * @version May 3, 2021
 */

public class NotificationUpdate extends JFrame {

    public NotificationUpdate(User u) {
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                u.setOnline(false);
                Server.writeToFile();
            }
        });
        Timer timer = new Timer();
        JFrame notification = new JFrame("Notifications");
        notification.setLayout(new BorderLayout());
        notification.setSize(500, 500);
        notification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ArrayList<User> sent = u.getSentReqs();
        ArrayList<User> rec = u.getReceivedReqs();
        AtomicInteger numSent = new AtomicInteger(u.getSentReqs().size());
        AtomicInteger numRec = new AtomicInteger(u.getSentReqs().size());


        ArrayList<JPanel> panels = new ArrayList<>();
        if (sent != null) {
            for (int i = 0; i < u.getSentReqs().size(); i++) {
                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout(FlowLayout.LEFT));
                JLabel sentLabel = new JLabel("Sent: ");
                User user = u.getSentReqs().get(i);
                JButton profileButton = new JButton("View Profile");
                profileButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        notification.setVisible(false);
                        notification.dispose();
                        AllProfiles profile = new AllProfiles(user, u);
                        timer.cancel();
                    }
                });
                JButton rescind = new JButton("Rescind");
                rescind.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        u.cancelNotification(u, user);
                    }
                });
                JLabel nameLabel = new JLabel(user.getFirstName() + " " + user.getLastName());
                panel.add(sentLabel);
                panel.add(nameLabel);
                panel.add(profileButton);
                panel.add(rescind);
                panels.add(panel);
            }
        }
        if (rec != null) {
            for (int i = 0; i < u.getReceivedReqs().size(); i++) {
                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout(FlowLayout.LEFT));
                User user = u.getReceivedReqs().get(i);
                JLabel recLabel = new JLabel("Received: ");
                JLabel nameLabel = new JLabel(user.getFirstName() + " " + user.getLastName());
                JButton profileButton = new JButton("View Profile");
                profileButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        notification.setVisible(false);
                        notification.dispose();
                        AllProfiles profile = new AllProfiles(user, u);
                        timer.cancel();
                    }
                });
                JButton accept = new JButton("Accept");
                accept.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        u.removeAccDec(u, user);
                        u.getFriends().add(user);
                        user.getFriends().add(u);
                        Server.writeToFile();
                    }
                });
                JButton decline = new JButton("Decline");
                decline.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        u.removeAccDec(u, user);
                    }
                });
                panel.add(recLabel);
                panel.add(nameLabel);
                panel.add(profileButton);
                panel.add(accept);
                panel.add(decline);
                panels.add(panel);
            }
        }

        JPanel panelScroll = new JPanel();
        panelScroll.setLayout(new CardLayout());

        for (int i = 0; i < panels.size(); i++) {
            panelScroll.add(panels.get(i));
        }

        JScrollPane scrollPane = new JScrollPane(panelScroll);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        JPanel topPanel = new JPanel();
        JButton home = new JButton("Home");
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    notification.setVisible(false);
                    notification.dispose();
                    timer.cancel();
                    MainPage main = new MainPage(u);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        topPanel.add(home);
        notification.add(topPanel, BorderLayout.NORTH);
        notification.add(scrollPane);
        notification.setVisible(true);
        notification.setLocationRelativeTo(null);

        TimerTask task = new TimerTask() {
            public void run() {

                boolean different = false;
                ArrayList<User> sent = u.getSentReqs();
                ArrayList<User> rec = u.getReceivedReqs();

                if (sent.size() != numSent.get()) {
                    different = true;
                    numSent.set(sent.size());
                }
                if (rec.size() != numRec.get()) {
                    different = true;
                    numRec.set(rec.size());
                }

                if (different) {
                    notification.remove(scrollPane);
                    ArrayList<JPanel> panels = new ArrayList<>();
                    if (sent != null) {
                        for (int i = 0; i < u.getSentReqs().size(); i++) {
                            JPanel panel = new JPanel();
                            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
                            JLabel sentLabel = new JLabel("Sent: ");
                            User user = u.getSentReqs().get(i);
                            JButton profileButton = new JButton("View Profile");
                            profileButton.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    notification.setVisible(false);
                                    notification.dispose();
                                    AllProfiles profile = new AllProfiles(user, u);
                                    timer.cancel();
                                }
                            });
                            JButton rescind = new JButton("Rescind");
                            rescind.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    u.cancelNotification(u, user);
                                }
                            });
                            JLabel nameLabel = new JLabel(user.getFirstName() + " " + user.getLastName());
                            panel.add(sentLabel);
                            panel.add(nameLabel);
                            panel.add(profileButton);
                            panel.add(rescind);
                            panels.add(panel);
                        }
                    }
                    if (rec != null) {
                        for (int i = 0; i < u.getReceivedReqs().size(); i++) {
                            JPanel panel = new JPanel();
                            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
                            User user = u.getReceivedReqs().get(i);
                            JLabel recLabel = new JLabel("Received: ");
                            JLabel nameLabel = new JLabel(user.getFirstName() + " " + user.getLastName());
                            JButton profileButton = new JButton("View Profile");
                            JButton accept = new JButton("Accept");
                            JButton decline = new JButton("Decline");
                            profileButton.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    notification.setVisible(false);
                                    notification.dispose();
                                    AllProfiles profile = new AllProfiles(user, u);
                                    timer.cancel();
                                }
                            });

                            accept.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    u.removeAccDec(u, user);
                                    u.getFriends().add(user);
                                    user.getFriends().add(u);
                                    accept.setEnabled(false);
                                    decline.setEnabled(false);
                                    profileButton.setEnabled(false);
                                    Server.writeToFile();
                                }
                            });

                            decline.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    u.removeAccDec(u, user);
                                    accept.setEnabled(false);
                                    decline.setEnabled(false);
                                    profileButton.setEnabled(false);
                                }
                            });
                            panel.add(recLabel);
                            panel.add(nameLabel);
                            panel.add(profileButton);
                            panel.add(accept);
                            panel.add(decline);
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

                    notification.add(scrollPane);
                    notification.setVisible(true);
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
