import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for Main page of project where user is given option to visit various tabs
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 5
 * @author Sudhanva Bharadwaj, Colten Glover, Brayden Hall, Japneet Mavi, Jeff Woodhouse
 * @version May 3, 2021
 */

public class MainPage extends JFrame {

    JButton profile;
    JPanel panel;

    public MainPage(User user) throws IOException {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                user.setOnline(false);
                Server.writeToFile();
                dispose();
            }
        });

        //FRAME SETUP//
        setTitle("Welcome " + user.getFirstName() + " | FindABoiler");
        setSize(new Dimension(500, 500));
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
        profile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new MyProfile(user);
            }
        });
        panel.add(profile, g);

        g.gridx++;
        JButton explore = new JButton("Explore");
        explore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new ExploreUpdate(user);
            }
        });
        panel.add(explore, g);

        g.gridx++;
        JButton notifications = new JButton("Notifications");
        notifications.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                NotificationUpdate notification = new NotificationUpdate(user);
            }
        });
        panel.add(notifications, g);

        g.gridx++;
        JButton logout = new JButton("Logout");
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ACTUAL CODE
                user.setOnline(false);
                Server.activeUsers.remove(user);
                Server.writeToFile();
                setVisible(false);
                dispose();
                try {
                    LoginFrame lf = new LoginFrame();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        panel.add(logout, g);
        // BUTTONS FOR USER TO INTERACT WITH

        // SEARCH FUNCTION
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
                    SearchFrame sf = new SearchFrame(potentialUsers, user);
                }
            }
        });

        searchPanel.add(searchBar, gc);
        add(searchPanel, BorderLayout.SOUTH);
        // SEARCH FUNCTION



        // PICTURE

        BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\ketch\\IdeaProjects\\Homework 12\\SoloPJ5\\src\\PurdueLogo.jpg"));
        Image scaledImage = myPicture.getScaledInstance(getWidth() -100, getHeight() -100,Image.SCALE_SMOOTH);
        JLabel picLabel = new JLabel(new ImageIcon(scaledImage));
        add(picLabel, BorderLayout.CENTER);
        

        add(panel, BorderLayout.NORTH);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
