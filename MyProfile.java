//with profile pic

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * Class for the cureent logged in user's profile and all their information
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 5
 *
 * @author Sudhanva Bharadwaj, Colten Glover, Brayden Hall, Japneet Mavi, Jeff Woodhouse
 * @version May 3, 2021
 */


public class MyProfile extends JFrame {

    public MyProfile(User user) {
        setTitle("My Profile");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                user.setOnline(false);
                Server.writeToFile();
            }
        });

        Border br = BorderFactory.createLineBorder(Color.YELLOW, 5);
        setLayout(new BorderLayout());

        JPanel jp = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        jp.setBackground(Color.PINK);
        JLabel pic;
        pic = user.getIcon();
        JButton toReturn = new JButton("Return to Main Page");
        toReturn.setOpaque(true);
        toReturn.setBackground(Color.CYAN);
        toReturn.setBorder(br);
        toReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                    dispose();
                    new MainPage(user);
                } catch (IOException ioex) {
                    //
                }
            }
        });


        JLabel username = new JLabel(user.getUsername());
        username.setOpaque(true);
        username.setBackground(Color.CYAN);
        username.setBorder(br);

        JLabel aboutMe = new JLabel("BIO : " + user.getBio());

        JButton friends = new JButton("Friends");
        friends.setOpaque(true);
        friends.setBackground(Color.CYAN);
        friends.setBorder(br);
        friends.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new FriendsProfile(user);

            }
        });

        /** String interest ="";
         for (int i = 0; i < (user.getInterests())Str.size(); i++) {
         interest = interest + ((user.getInterests()).get(i) + "\n");
         }  */


        /**
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

        JButton contact = new JButton("Contact Info");
        contact.setOpaque(true);
        contact.setBackground(Color.CYAN);
        contact.setBorder(br);
        contact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, user.getEmail(), "Email",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton settings = new JButton("Settings");
        settings.setOpaque(true);
        settings.setBackground(Color.CYAN);
        settings.setBorder(br);
        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new SettingsFrame(user);
            }
        });
        jp.setLayout(new GridBagLayout());

        gbc.gridx = 1;
        gbc.gridy = 1;
        jp.add(pic, gbc);

        username.setPreferredSize(new Dimension(150, 50));
        gbc.gridx = 1;
        gbc.gridy = 0;
        jp.add(username, gbc);

        aboutMe.setPreferredSize(new Dimension(150, 50));
        gbc.gridx = 1;
        gbc.gridy = 2;
        jp.add(aboutMe, gbc);

        friends.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 1;
        jp.add(friends, gbc);

        String interest = String.valueOf(user.getInterests() + "\n");
        String[] rest = interest.split(",");
        JLabel interests;


        int y = 2;
        Border b = BorderFactory.createLineBorder(Color.PINK, 3);

        for (int i = 0; i < (user.getInterests()).size(); i++) {
            interests = new JLabel((i + 1) + " " + ((user.getInterests()).get(i)));
            interests.setBorder(b);
            interests.setOpaque(true);
            interests.setBackground(Color.YELLOW);
            gbc.gridx = 1;
            y = y + 1;
            gbc.gridy = y;

            jp.add(interests, gbc);


            //y++;
        }


        /**
         interests.setPreferredSize(new Dimension(150, 30));
         gbc.gridx = 1;
         gbc.gridy = 3;
         jp.add(interests, gbc);
         */

        contact.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 2;
        gbc.gridy = 3;
        jp.add(contact, gbc);

        toReturn.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 1;
        jp.add(toReturn, gbc);

        settings.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        jp.add(settings, gbc);

        add(jp, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
