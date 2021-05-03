//updated one

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

/**
 * Class for all your friends and their information
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 5
 *
 * @author Sudhanva Bharadwaj, Colten Glover, Brayden Hall, Japneet Mavi, Jeff Woodhouse
 * @version May 3, 2021
 */

public class FriendsProfile extends JFrame {
    public FriendsProfile(User user) {
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                user.setOnline(false);
                Server.writeToFile(); // Data is saved even if server crashes
            }
        });
        setTitle("Friends");
        setLayout(new BorderLayout());
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel jp = new JPanel();
        jp.setBackground(Color.PINK);
        jp.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton returnto = new JButton("Return to My Profile");
        returnto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new MyProfile(user);
            }
        });

        returnto.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        jp.add(returnto, gbc);

        int y = 1;
        int yy = 1;
        for (int i = 0; i < ((user.getFriends()).size()); i++) {
            String[] names = new String[(user.getFriends()).size()];
            User[] fname = new User[(user.getFriends()).size()];
            fname[i] = user.getFriends().get(i);
            names[i] = String.valueOf((user.getFriends()).get(i));
            JLabel flist = new JLabel(names[i]); // List of all friends

            flist.setPreferredSize(new Dimension(35, 30));
            gbc.gridx = 0;
            gbc.gridy = y++;
            gbc.anchor = GridBagConstraints.FIRST_LINE_END;
            jp.add(flist, gbc);

            User fname1 = fname[i];

            JButton jb = new JButton("View Profile"); // Button created to view profile
            jb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    dispose();
                    new AllProfiles(fname1, user); // Closes previous frame and displays friend
                }
            });
            jb.setPreferredSize(new Dimension(150, 30));
            gbc.gridx = 1;
            gbc.gridy = yy++;
            jp.add(jb, gbc);
        }


        add(jp, BorderLayout.CENTER);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
