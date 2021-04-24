import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class Notification extends JFrame {

    public Notification(User u) {
        setTitle("Notifications");
        setSize(new Dimension(600,600));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        ArrayList<User> pendingUsers = new ArrayList<>();
        pendingUsers.addAll(u.getReceivedReqs());
        ArrayList<User> sentUsers = new ArrayList<>();
        sentUsers.addAll(u.getSentReqs());
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
                        u.removeAccDec(u, pendingUsers.get(finalI));
                        u.getFriends().add(pendingUsers.get(finalI));
                        pendingUsers.get(finalI).getFriends().add(u);
                    }
                });

                JButton declineButton = new JButton("Decline");
                declineButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        u.removeAccDec(u, pendingUsers.get(finalI));
                    }
                });
                JLabel name = new JLabel(pendingUsers.get(i).getFirstName() + " " + pendingUsers.get(i).getLastName());

                panel.add(name);
                panel.add(profileButton);
                panel.add(acceptButton);
                panel.add(declineButton);
                panels.add(panel);
            }
        }
        // ADD SENT PART BELOW

        ArrayList<JPanel> panels1 = new ArrayList<>();

        if (sentUsers != null) {
            for (int i = 0; i < sentUsers.size(); i++) {
                JPanel panel = new JPanel();
                JButton profileButton = new JButton("View Profile");
                int finalI = i;
                profileButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(sentUsers.get(finalI).getUsername() + "'s Profile");
                    }
                });
                JButton cancelButton = new JButton("Rescind");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        u.cancelNotification(u, sentUsers.get(finalI));
                    }
                });

                JLabel name = new JLabel(sentUsers.get(i).getFirstName() + " " + sentUsers.get(i).getLastName());

                panel.add(name);
                panel.add(profileButton);
                panel.add(cancelButton);
                panels1.add(panel);
            }
        }

        JPanel panelScroll = new JPanel();
        panelScroll.setLayout(new GridLayout(panels.size(), 1));

        for (int i = 0; i < panels.size(); i++) {
            panelScroll.add(panels.get(i));
        }

        JPanel panelScroll1 = new JPanel();
        panelScroll1.setLayout(new GridLayout(panels1.size(), 1));

        for (int i = 0; i < panels1.size(); i++) {
            panelScroll1.add(panels1.get(i));
        }

        JScrollPane scrollPaneR = new JScrollPane(panelScroll);
        scrollPaneR.getVerticalScrollBar().setUnitIncrement(16);

        JScrollPane scrollPaneS = new JScrollPane(panelScroll1);
        scrollPaneS.getVerticalScrollBar().setUnitIncrement(16);

        JPanel topPanel = new JPanel();
        JButton home = new JButton("Home");
        home.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                    dispose();
                    MainPage main = new MainPage(u);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        setLocationRelativeTo(null);

        topPanel.add(home);
        add(topPanel, BorderLayout.NORTH);
        add(scrollPaneR, BorderLayout.CENTER);
        add(scrollPaneS, BorderLayout.SOUTH);
        setVisible(true);
    }
}
