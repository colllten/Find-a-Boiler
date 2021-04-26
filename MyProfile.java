import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;

public class MyProfile extends JFrame {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MyProfile();
            }
        });


    }
    private static void MyProfile() {
        JFrame jf = new JFrame("My profile");
        JPanel jp = new JPanel();
        User u = new User();
        GridBagConstraints gbc = new GridBagConstraints();
        jp.setBackground(Color.PINK);
        JButton pic = new JButton("pic");
        JLabel username = new JLabel(u.getUsername());

        JLabel aboutme = new JLabel(u.getBio());
        JButton friends = new JButton("friends");
        friends.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] namef = new Object[(u.getFriends()).size()];
                namef = (u.getFriends()).toArray();
                String[] fname = new String[(u.getFriends()).size()];
                for (int i = 0; i < (u.getFriends()).size(); i++) {
                    fname[i] = String.valueOf(namef[i]);
                }
                JOptionPane.showMessageDialog(jf, fname);

            }
        });
        JButton interests = new JButton("interests");
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
        JButton contact = new JButton("contact");
        contact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jf, u.getEmail());
            }
        });

        JButton settings = new JButton ("settings");
        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // new Settings();
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
        jp.add(aboutme, gbc);

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

        jf.add(jp);
        jf.pack();
        jf.setVisible(true);

        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //jf. setLayout(new GridBagLayout());
        jf.setSize(600, 600);

        //jf..pack();
        jf.setVisible(true);
    }







}