import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainPage extends JFrame {

    JButton profile;
    JPanel panel;

    public MainPage(User user) throws IOException {
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
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JButton search = new JButton("Search");
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        searchPanel.add(search, gc);

        gc.gridx++;
        JTextField searchBar = new JTextField(10);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = searchBar.getText();
                boolean usersFound = false;
                ArrayList<User> potentialUsers = new ArrayList<>();
                for (int i = 0; i < Server.totalUsers.size(); i++) {
                    if (Server.totalUsers.get(i).getUsername().contains(username)) {
                        potentialUsers.add(Server.totalUsers.get(i));
                        usersFound = true;
                    }
                }
                if (!usersFound) {
                    JOptionPane.showMessageDialog(null, "User not found", "Not Found", JOptionPane.WARNING_MESSAGE);
                } else {
                    SearchFrame sf = new SearchFrame(potentialUsers);
                }
            }
        });
        //new comment

        searchPanel.add(searchBar, gc);
        add(searchPanel, BorderLayout.SOUTH);


        //SEARCH FUNCTION//

        //USE OF ARRAYS//
        JPanel totalUserPanel = new JPanel();
        totalUserPanel.setLayout(new BorderLayout());
        JLabel count = new JLabel("Total Users: " + Server.totalUsers.size());
        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count.setText("Total Users: " + Server.totalUsers.size());
            }
        });
        totalUserPanel.add(refresh, BorderLayout.NORTH);
        totalUserPanel.add(count, BorderLayout.SOUTH);
        add(totalUserPanel, BorderLayout.WEST);
        //USE OF ARRAYS//

        //PICTURE//
        /*
        BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\ketch\\Pictures\\Screenshots\\mainPageImage.jpg"));
        Image scaledImage = myPicture.getScaledInstance(getWidth() -100, getHeight() -100,Image.SCALE_SMOOTH);
        JLabel picLabel = new JLabel(new ImageIcon(scaledImage));
        add(picLabel, BorderLayout.CENTER);
         */
        //PICTURE//

        add(panel, BorderLayout.NORTH);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
