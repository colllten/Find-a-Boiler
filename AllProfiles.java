import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * Class for for all profiles avalible to view
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 5
 *
 * @author Sudhanva Bharadwaj, Colten Glover, Brayden Hall, Japneet Mavi, Jeff Woodhouse
 * @version May 3, 2021
 */

public class AllProfiles extends JFrame {

    public AllProfiles(User user, User currentUser) {

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                currentUser.setOnline(false);
                Server.writeToFile(); // Used to save data even when Server is shut down. Data written to and from a
                // txt file
            }
        });
        setTitle(user.getUsername() + "'s Profile"); // Layout with username of current user displayed at the top
        setLayout(new BorderLayout());
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Border br = BorderFactory.createLineBorder(Color.YELLOW, 5);


        JPanel jp = new JPanel();
        jp.setBackground(Color.PINK);
        jp.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel pic;
        pic = currentUser.getIcon();
        JButton toReturn = new JButton("Return to Main Page"); // Button that allows users to return to the home
        // page
        toReturn.setOpaque(true);
        toReturn.setBackground(Color.CYAN);
        toReturn.setBorder(br);
        toReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                    dispose();
                    new MainPage(currentUser); // New Main Page is created and the previous page is set to not visible
                } catch (IOException ioex) {
                    //
                }
            }
        });


        JLabel username = new JLabel(user.getUsername());
        username.setOpaque(true);
        username.setBackground(Color.CYAN);
        username.setBorder(br);

        JLabel aboutMe = new JLabel("Bio : " + user.getBio()); // Creates a bio with the bio the user entered at
        // registration

        JButton friends = new JButton("Friends"); // A button a user can select to view all friends
        friends.setOpaque(true);
        friends.setBackground(Color.CYAN);
        friends.setBorder(br);
        friends.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // If the button is clicked, the previous page they were
                // on is not visible, as friends is shown
                setVisible(false);
                dispose();
                new FriendsProfile(user);

            }
        });

        /* String interest ="";
         for (int i = 0; i < (user.getInterests())Str.size(); i++) {
         interest = interest + ((user.getInterests()).get(i) + "\n");
         }  */


        /*
         interests.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         Object[] interests = new Object[(user.getFriends()).size()];
         interests = (user.getFriends()).toArray();
         String[] intStr = new String[(user.getFriends()).size()];
         for (int i = 0; i < (user.getFriends()).size(); i++) {
         intStr[i] = String.valueOf(interests[i]);
         }
         JOptionPane.showMessageDialog(null, intStr);
         }
         }); */

        JButton contact = new JButton("Contact Info"); // Contact info button is created
        contact.setOpaque(true);
        contact.setBackground(Color.CYAN);
        contact.setBorder(br);
        contact.addActionListener(new ActionListener() { // If the contact info button is clicked, user's email is shown
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, user.getEmail(), "Email",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });


        jp.setLayout(new GridBagLayout());

        gbc.gridx = 1;
        gbc.gridy = 1;
        jp.add(pic, gbc); // Used for user's profile picture

        username.setPreferredSize(new Dimension(150, 50));
        gbc.gridx = 1;
        gbc.gridy = 0;
        jp.add(username, gbc); // username display

        aboutMe.setPreferredSize(new Dimension(150, 50));
        gbc.gridx = 1;
        gbc.gridy = 2;
        jp.add(aboutMe, gbc); // bio display

        friends.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 1;
        jp.add(friends, gbc); // friends display

        String interest = String.valueOf(user.getInterests() + "\n");
        String[] rest = interest.split(",");
        JLabel interests;


        int y = 2;
        Border b = BorderFactory.createLineBorder(Color.PINK, 3);

        for (int i = 0; i < (user.getInterests()).size(); i++) { // Loops through all the user's interests
            interests = new JLabel((i + 1) + " " + ((user.getInterests()).get(i)));
            interests.setBorder(b);
            interests.setOpaque(true);
            interests.setBackground(Color.YELLOW);
            gbc.gridx = 1;
            y = y + 1;
            gbc.gridy = y;

            jp.add(interests, gbc); // List of user's interests is displayed on Profile


            //y++;
        }


        /*
         interests.setPreferredSize(new Dimension(150, 30));
         gbc.gridx = 1;
         gbc.gridy = 3;
         jp.add(interests, gbc);
         */

        contact.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 2;
        gbc.gridy = 3;
        jp.add(contact, gbc); // contact button aded

        toReturn.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 1;
        jp.add(toReturn, gbc);


        add(jp, BorderLayout.CENTER);
        //jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
