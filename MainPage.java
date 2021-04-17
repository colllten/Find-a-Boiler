import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainPage extends JFrame {

    JButton profile;
    JPanel panel;

    public MainPage(User user) {
        //FRAME SETUP//
        setTitle("Welcome " + user.getFirstName());
        setSize(new Dimension(600, 600));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        //FRAME SETUP//

        //BUTTONS//
        g.anchor = GridBagConstraints.CENTER;
        g.weightx = 0.5;

        g.gridx = 0;
        g.gridy = 0;
        profile = new JButton("My Profile");
        panel.add(profile, g);

        g.gridx++;
        JButton explore = new JButton("Explore");
        panel.add(explore, g);

        g.gridx++;
        JButton notifications = new JButton("Notifications");
        panel.add(notifications, g);

        g.gridx++;
        JButton friendsList = new JButton("Friends");
        friendsList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        panel.add(friendsList, g);

        g.gridx++;
        JButton logout = new JButton("Logout");
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //ACTUAL CODE//
                user.setOnline(false);
                Server.activeUsers.remove(user);
                setVisible(false);
                dispose();
            }
        });
        panel.add(logout, g);

        //BUTTONS//

        //SEARCH FUNCTION//
        //SEARCH FUNCTION//

        this.add(panel, BorderLayout.NORTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
