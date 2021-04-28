import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;

public class MyProfile extends JFrame {

    public MyProfile(User user) {
        setTitle("My Profile");
        setLayout(new BorderLayout());
        JPanel jp = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        jp.setBackground(Color.PINK);
        JButton pic = new JButton("Profile Picture");
        JLabel username = new JLabel(user.getUsername());

        JLabel aboutMe = new JLabel(user.getBio());
        JButton friends = new JButton("Friends");
        //friends.addActionListener(new ActionListener() {
        //public void actionPerformed(ActionEvent e) {
        //Object[] namef = new Object[(user.getFriends()).size()];
        //namef = (u.getFriends()).toArray();
                /*
                String[] fname = new String[(user.getFriends()).size()];
                for (int i = 0; i < (user.getFriends()).size(); i++) {
                    fname[i] = String.valueOf(namef[i]);
                }
                JOptionPane.showMessageDialog(jf, fname);

            }
        });*/

        JButton interests = new JButton("Interests");
        /*
        interests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] interests = new Object[(u.getFriends()).size()];
                interests = (u.getFriends()).toArray();
                String[] intStr = new String[(u.getFriends()).size()];
                for (int i = 0; i < (u.getFriends()).size(); i++) {
                    intStr[i] = String.valueOf(interests[i]);
                }
                JOptionPane.showMessageDialog(jf, intStr);

            }
        });

         */
        JButton contact = new JButton("Contact Info");
        contact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, user.getEmail(), "Email", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton settings = new JButton("Settings");
        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new SettingsFrame(user);
            }
        });
        jp.setLayout(new GridBagLayout());

        gbc.gridx = 1;
        gbc.gridy = 0;
        jp.add(pic, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        jp.add(username, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        jp.add(aboutMe, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        jp.add(friends, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        jp.add(interests, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        jp.add(contact, gbc);

        gbc.gridx = 6;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        jp.add(settings, gbc);

        add(jp, BorderLayout.CENTER);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}